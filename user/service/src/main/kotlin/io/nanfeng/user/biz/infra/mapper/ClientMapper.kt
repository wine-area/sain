package io.nanfeng.user.biz.infra.mapper

import io.nanfeng.user.biz.domain.client.entity.OAuth2ClientEntity
import io.nanfeng.user.biz.domain.client.entity.OAuth2ClientSettingsEntity
import io.nanfeng.user.biz.domain.client.entity.OAuth2TokenSettingsEntity
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.core.oidc.OidcScopes
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import java.time.Instant
import java.util.*


fun OAuth2ClientEntity.toRegisteredClient(): RegisteredClient {

    val clientAuthMethods = clientAuthenticationMethods
    val oAuth2GrantTypes = authorizationGrantTypes
    val oAuth2Scopes = scopes
    val builder = RegisteredClient.withId(id.toString())
        .clientId(Optional.ofNullable(clientId).orElse(UUID.randomUUID().toString()))
        .clientSecret(clientSecret)
        .clientIdIssuedAt(clientIdIssuedAt)
        .clientSecretExpiresAt(clientSecretExpiresAt)
        .clientName(clientName)
        .clientAuthenticationMethods { clientAuthenticationMethodSet: MutableSet<ClientAuthenticationMethod> ->
            clientAuthenticationMethodSet.addAll(clientAuthMethods.map(::ClientAuthenticationMethod))
        }
        .authorizationGrantTypes { authorizationGrantTypeSet: MutableSet<AuthorizationGrantType> ->
            authorizationGrantTypeSet.addAll(
                oAuth2GrantTypes.map(::AuthorizationGrantType)
            )
        }
        .redirectUris { redirectUriSet: MutableSet<String> ->
            redirectUriSet.addAll(redirectUris)
        }
        .scopes { scopeSet: MutableSet<String> ->
            scopeSet.addAll(oAuth2Scopes)
        }
        .scope(OidcScopes.OPENID)
        .clientSettings(clientSettings.toClientSettings())
        .tokenSettings(tokenSettings.toTokenSettings())
    return builder.build()
}

fun RegisteredClient.toOAuth2ClientEntity(): OAuth2ClientEntity {
    val registeredClient = this
    val oAuth2Client = OAuth2ClientEntity()
    oAuth2Client.id = registeredClient.id.toLong()
    val clientId = registeredClient.clientId
    oAuth2Client.clientId = clientId
    oAuth2Client.clientIdIssuedAt = registeredClient.clientIdIssuedAt ?: Instant.now()
    oAuth2Client.clientSecret = registeredClient.clientSecret ?: UUID.randomUUID().toString()
    oAuth2Client.clientName = registeredClient.clientName
    oAuth2Client.clientAuthenticationMethods = registeredClient.clientAuthenticationMethods
        .map(ClientAuthenticationMethod::getValue)
        .toSet()
    oAuth2Client.authorizationGrantTypes = registeredClient
        .authorizationGrantTypes
        .map(AuthorizationGrantType::getValue)
        .toSet()
    oAuth2Client.redirectUris = registeredClient.redirectUris
    oAuth2Client.scopes = registeredClient.scopes
    val settings: OAuth2ClientSettingsEntity = registeredClient.clientSettings.toOauth2ClientSetting()
    settings.clientId = clientId
    oAuth2Client.clientSettings = settings
    val oAuth2TokenSettingsEntity: OAuth2TokenSettingsEntity =
        OAuth2TokenSettingsEntity.fromTokenSettings(registeredClient.tokenSettings)
    oAuth2TokenSettingsEntity.clientId = clientId
    oAuth2Client.tokenSettings = oAuth2TokenSettingsEntity
    return oAuth2Client
}