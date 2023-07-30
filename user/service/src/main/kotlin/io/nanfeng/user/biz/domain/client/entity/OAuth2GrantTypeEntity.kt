package io.nanfeng.user.biz.domain.client.entity

import org.springframework.security.oauth2.core.AuthorizationGrantType
import java.io.Serializable

class OAuth2GrantTypeEntity : Serializable {
    lateinit var clientId: String

    lateinit var grantTypeName: String


    fun toGrantType(): AuthorizationGrantType {
        return AuthorizationGrantType(grantTypeName)
    }

    companion object {
        private const val serialVersionUID = -6157485899335872648L
    }
}


