package io.nanfeng.user.biz.domain.authorization.entity

import jakarta.persistence.*
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import java.io.Serializable

@Entity
@IdClass(ClientAuthMethodEntity.ClientAuthenticationMethodId::class)
@Table(name = "client_auth_method")
class ClientAuthMethodEntity : Serializable {
    @Id
    @Column(name = "client_id", insertable = false, updatable = false)
    lateinit var clientId: String

    @Id
    lateinit var clientAuthenticationMethod: String

    data class ClientAuthenticationMethodId(
        var clientId: String, var clientAuthenticationMethod: String
    ) : Serializable {
        companion object {
            private const val serialVersionUID = 8357713071222963428L
        }
    }


    fun toAuthenticationMethod(): ClientAuthenticationMethod {
        return ClientAuthenticationMethod(clientAuthenticationMethod)
    }

    companion object {
        private const val serialVersionUID = 8357713071222963428L
    }
}