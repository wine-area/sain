package io.nanfeng.user.biz.domain.authorization.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.hibernate.Hibernate
import java.time.Instant

/**
 * @author globaliware
 */
@Entity
data class Authorization(
    var registeredClientId: String = "",
    var state: String = "",
    var principalName: String = "",
    var authorizationGrantType: String = "",
    @Column(columnDefinition = "TEXT")
    var attributes: String = "",
    @Column(columnDefinition = "TEXT")
    var authorizationCodeValue: String = "",
    var authorizationCodeIssuedAt: Instant? = null,
    var authorizationCodeExpiresAt: Instant? = null,
    @Column(columnDefinition = "TEXT")
    var authorizationCodeMetadata: String = "",
    @Column(columnDefinition = "TEXT")
    var accessTokenValue: String = "",
    var accessTokenIssuedAt: Instant? = null,
    var accessTokenExpiresAt: Instant? = null,
    @Column(columnDefinition = "TEXT")
    var accessTokenMetadata: String = "",
    @Column(columnDefinition = "TEXT")
    var accessTokenScopes: String = "",
    @Column(columnDefinition = "TEXT")
    var refreshTokenValue: String = "",
    var refreshTokenIssuedAt: Instant? = null,
    var refreshTokenExpiresAt: Instant? = null,
    @Column(columnDefinition = "TEXT")
    var refreshTokenMetadata: String = "",
    @Column(columnDefinition = "TEXT")
    var idTokenValue: String = "",
    var idTokenIssuedAt: Instant? = null,
    var idTokenExpiresAt: Instant? = null,
    @Column(columnDefinition = "TEXT")
    var idTokenMetadata: String = "",
    @Column(columnDefinition = "TEXT")
    var idTokenClaims: String = "",


    ) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Authorization

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(registeredClientId = $registeredClientId , principalName = $principalName )"
    }
}