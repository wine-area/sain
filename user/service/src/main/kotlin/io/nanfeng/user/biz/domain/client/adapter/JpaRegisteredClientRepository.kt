package io.nanfeng.user.biz.domain.client.adapter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.nanfeng.user.biz.domain.client.entity.RegisteredClientEntity
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings
import org.springframework.stereotype.Component
import org.springframework.util.Assert
import org.springframework.util.StringUtils

@Component
class JpaRegisteredClientRepository(
    private val clientRepository: io.nanfeng.user.biz.domain.client.repository.RegisteredClientRepository,
    private val objectMapper: ObjectMapper
) : RegisteredClientRepository {


    override fun save(registeredClient: RegisteredClient) {
        Assert.notNull(registeredClient, "registeredClient cannot be null")
        clientRepository.save(toEntity(registeredClient))
    }

    override fun findById(id: String): RegisteredClient? {
        Assert.hasText(id, "id cannot be empty")
        return clientRepository.findById(id.toLong()).map { client: RegisteredClientEntity -> toObject(client) }
            .orElse(null)
    }

    override fun findByClientId(clientId: String): RegisteredClient? {
        Assert.hasText(clientId, "clientId cannot be empty")
        return clientRepository.findByClientId(clientId).let(this::toObject)
    }

    private fun toObject(client: RegisteredClientEntity?): RegisteredClient? {
        client ?: return null
        val clientAuthenticationMethods = StringUtils.commaDelimitedListToSet(client.clientAuthenticationMethods)
        val authorizationGrantTypes = StringUtils.commaDelimitedListToSet(client.authorizationGrantTypes)
        val redirectUris = StringUtils.commaDelimitedListToSet(client.redirectUris)
        val clientScopes = StringUtils.commaDelimitedListToSet(client.scopes)
        val builder: RegisteredClient.Builder = RegisteredClient.withId(client.id.toString())
            .clientId(client.clientId).clientIdIssuedAt(client.clientIdIssueAt)
            .clientSecret(client.clientSecret)
            .clientSecretExpiresAt(client.clientSecretExpiresAt).clientName(client.clientName)
            .clientAuthenticationMethods { authenticationMethods: MutableSet<ClientAuthenticationMethod?> ->
                clientAuthenticationMethods
                    .forEach { authenticationMethod ->
                        authenticationMethods
                            .add(resolveClientAuthenticationMethod(authenticationMethod))
                    }
            }
            .authorizationGrantTypes { grantTypes: MutableSet<AuthorizationGrantType?> ->
                authorizationGrantTypes
                    .forEach { grantType: String -> grantTypes.add(resolveAuthorizationGrantType(grantType)) }
            }
            .redirectUris { uris: MutableSet<String?> -> uris.addAll(redirectUris) }
            .scopes { scopes: MutableSet<String?> -> scopes.addAll(clientScopes) }
        val clientSettingsMap = parseMap(client.clientSettings)
        builder.clientSettings(ClientSettings.withSettings(clientSettingsMap).build())
        val tokenSettingsMap = parseMap(client.tokenSettings)
        builder.tokenSettings(TokenSettings.withSettings(tokenSettingsMap).build())
        return builder.build()
    }

    private fun toEntity(registeredClient: RegisteredClient): RegisteredClientEntity {
        val clientAuthenticationMethods: MutableList<String> =
            ArrayList(registeredClient.clientAuthenticationMethods.size)
        registeredClient.clientAuthenticationMethods
            .forEach { clientAuthenticationMethod: ClientAuthenticationMethod ->
                clientAuthenticationMethods.add(clientAuthenticationMethod.value)
            }
        val authorizationGrantTypes: MutableList<String> =
            ArrayList(registeredClient.authorizationGrantTypes.size)
        registeredClient.authorizationGrantTypes
            .forEach { authorizationGrantType: AuthorizationGrantType ->
                authorizationGrantTypes.add(authorizationGrantType.value)
            }
        return RegisteredClientEntity(
            clientId = registeredClient.clientId,
            clientIdIssueAt = registeredClient.clientIdIssuedAt,
            clientSecret = registeredClient.clientSecret,
            clientSecretExpiresAt = registeredClient.clientSecretExpiresAt,
            clientName = registeredClient.clientName,
            clientAuthenticationMethods = StringUtils.collectionToCommaDelimitedString(clientAuthenticationMethods),
            authorizationGrantTypes = StringUtils.collectionToCommaDelimitedString(authorizationGrantTypes),
            redirectUris = StringUtils.collectionToCommaDelimitedString(registeredClient.redirectUris),
            scopes = StringUtils.collectionToCommaDelimitedString(registeredClient.scopes)
        )

    }

    private fun parseMap(data: String): Map<String, Any> {
        return try {
            objectMapper.readValue(data, object : TypeReference<Map<String, Any>>() {})
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException(ex.message, ex)
        }
    }

    private fun writeMap(data: Map<String, Any>): String {
        return try {
            objectMapper.writeValueAsString(data)
        } catch (ex: JsonProcessingException) {
            throw IllegalArgumentException(ex.message, ex)
        }
    }

    companion object {
        private fun resolveAuthorizationGrantType(authorizationGrantType: String): AuthorizationGrantType {
            return when (authorizationGrantType) {
                AuthorizationGrantType.AUTHORIZATION_CODE.value -> {
                    AuthorizationGrantType.AUTHORIZATION_CODE
                }

                AuthorizationGrantType.CLIENT_CREDENTIALS.value -> {
                    AuthorizationGrantType.CLIENT_CREDENTIALS
                }

                AuthorizationGrantType.REFRESH_TOKEN.value -> {
                    AuthorizationGrantType.REFRESH_TOKEN
                }

                else -> AuthorizationGrantType(authorizationGrantType)
            }
        }

        private fun resolveClientAuthenticationMethod(clientAuthenticationMethod: String): ClientAuthenticationMethod {
            return when (clientAuthenticationMethod) {
                ClientAuthenticationMethod.CLIENT_SECRET_BASIC.value -> {
                    ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                }

                ClientAuthenticationMethod.CLIENT_SECRET_POST.value -> {
                    ClientAuthenticationMethod.CLIENT_SECRET_POST
                }

                ClientAuthenticationMethod.NONE.value -> {
                    ClientAuthenticationMethod.NONE
                }

                else -> ClientAuthenticationMethod(clientAuthenticationMethod)
            }
        }
    }
}