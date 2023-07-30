package io.nanfeng.user.biz.domain.client.adapter

import io.nanfeng.user.biz.domain.client.entity.OAuth2ClientEntity
import io.nanfeng.user.biz.domain.client.repository.OAuth2ClientEntityRepository
import io.nanfeng.user.biz.infra.mapper.toOAuth2ClientEntity
import io.nanfeng.user.biz.infra.mapper.toRegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.stereotype.Component

@Component
class SASClientRepositoryAdapter(
    private val oAuth2ClientEntityRepository: OAuth2ClientEntityRepository
) : RegisteredClientRepository {
    override fun save(registeredClient: RegisteredClient) {
        oAuth2ClientEntityRepository.save(registeredClient.toOAuth2ClientEntity())
    }

    override fun findById(id: String): RegisteredClient? {
        return oAuth2ClientEntityRepository
            .findById(id.toLong())
            .map(OAuth2ClientEntity::toRegisteredClient)
            .orElse(null)
    }

    override fun findByClientId(clientId: String): RegisteredClient? {
        return oAuth2ClientEntityRepository.findByClientId(clientId)?.toRegisteredClient()
    }
}