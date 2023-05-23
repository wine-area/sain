package io.nanfeng.user.biz.domain.oauth

import io.nanfeng.user.biz.repo.ApplicationRepository
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.stereotype.Component

@Component
class RegisteredClientRepositoryImpl(

    private val applicationRepository: ApplicationRepository
) : RegisteredClientRepository {
    override fun save(registeredClient: RegisteredClient) {
    }

    override fun findById(id: String?): RegisteredClient? {
        TODO("Not yet implemented")
    }

    override fun findByClientId(clientId: String?): RegisteredClient? {
        TODO("Not yet implemented")
    }
}