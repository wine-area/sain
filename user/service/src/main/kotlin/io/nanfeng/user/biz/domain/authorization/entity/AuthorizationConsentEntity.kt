package io.nanfeng.user.biz.domain.authorization.entity

import io.nanfeng.user.biz.domain.authorization.entity.AuthorizationConsentEntity.AuthorizationConsentId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import java.io.Serializable
import java.util.*

@Entity
@IdClass(AuthorizationConsentId::class)
class AuthorizationConsentEntity : Serializable {
    @Id
    lateinit var registeredClientId: String

    @Id
    lateinit var principalName: String

    @Column(length = 1000)
    lateinit var authorities: String

    data class AuthorizationConsentId(
        var registeredClientId: String,
        var principalName: String
    ) : Serializable {
        companion object {
            private const val serialVersionUID = -1813040366041244907L
        }
    }
}