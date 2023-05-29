package io.nanfeng.user.biz.domain.client.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.time.Instant

@Entity
@Table(name = "t_registered_client")
@org.hibernate.annotations.Table(appliesTo = "t_registered_client", comment = "注册客户端")
data class RegisteredClientEntity(
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
    var clientSecretExpiresAt: Instant? =null,
) : BaseEntity() {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as RegisteredClientEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , clientId = $clientId , clientName = $clientName , scopes = $scopes , clientSettings = $clientSettings , tokenSettings = $tokenSettings )"
    }

}

