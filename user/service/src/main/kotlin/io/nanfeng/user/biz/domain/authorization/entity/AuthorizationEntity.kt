package io.nanfeng.user.biz.domain.authorization.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.Instant


@Entity
@Table(name = "t_authorization")
class AuthorizationEntity() : BaseEntity() {

    lateinit var registeredClientId: String

    lateinit var principalName: String

    lateinit var authorizationGrantType: String

    @Column(columnDefinition = "TEXT")
    lateinit var attributes: String

    lateinit var state: String

    @Column(columnDefinition = "TEXT")
    lateinit var authorizationCodeValue: String

    lateinit var authorizationCodeIssuedAt: Instant

    lateinit var authorizationCodeExpiresAt: Instant

    @Column(columnDefinition = "TEXT")
    lateinit var authorizationCodeMetadata: String

    @Column(columnDefinition = "TEXT")
    lateinit var accessTokenValue: String

    lateinit var accessTokenIssuedAt: Instant

    lateinit var accessTokenExpiresAt: Instant

    @Column(columnDefinition = "TEXT")
    lateinit var accessTokenMetadata: String
    lateinit var accessTokenType: String

    @Column(columnDefinition = "TEXT")
    lateinit var accessTokenScopes: String

    @Column(columnDefinition = "TEXT")
    lateinit var refreshTokenValue: String

    lateinit var refreshTokenIssuedAt: Instant

    lateinit var refreshTokenExpiresAt: Instant

    @Column(columnDefinition = "TEXT")
    lateinit var refreshTokenMetadata: String

    @Column(columnDefinition = "TEXT")
    lateinit var oidcIdTokenValue: String

    lateinit var oidcIdTokenIssuedAt: Instant

    lateinit var oidcIdTokenExpiresAt: Instant

    @Column(columnDefinition = "TEXT")
    lateinit var oidcIdTokenMetadata: String

    @Column(columnDefinition = "TEXT")
    lateinit var oidcIdTokenClaims: String
}