package io.nanfeng.user.biz.domain.client.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.time.Instant

@Entity
@Table(name = "t_registered_client")
class RegisteredClientEntity(
    val clientId: String = "",
    var clientSecret: String? = null,
    var clientName: String = "",
    var scopes: String = "",
    var redirectUris: String = "",
    var authorizationGrantTypes: String = "",
    var clientAuthenticationMethods: String = "",
    var clientSettings: String = "",
    var clientIdIssueAt: Instant? = null,
    var tokenSettings: String = "",
    var clientSecretExpiresAt: Instant? = null,
) : BaseEntity()

