package io.nanfeng.user.biz.domain.authorization.entity

import io.nanfeng.user.biz.domain.authorization.entity.AuthorizationConsent.AuthorizationConsentId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import java.io.Serializable
import java.util.*

/**
 *
 * @author globaliware
 */
@Entity
@IdClass(AuthorizationConsentId::class)
class AuthorizationConsent : Serializable {
    @Id
    lateinit var registeredClientId: String

    @Id
    lateinit var principalName: String

    @Column(length = 1000)
    lateinit var authorities: String

    class AuthorizationConsentId : Serializable {
        lateinit var registeredClientId: String
        lateinit var principalName: String
        override fun equals(o: Any?): Boolean {
            if (this === o) return true
            if (o == null || javaClass != o.javaClass) return false
            val that = o as AuthorizationConsentId
            return registeredClientId == that.registeredClientId && principalName == that.principalName
        }

        override fun hashCode(): Int {
            return Objects.hash(registeredClientId, principalName)
        }
    }
}