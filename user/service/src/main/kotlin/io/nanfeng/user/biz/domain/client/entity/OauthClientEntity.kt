package io.nanfeng.user.biz.domain.client.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["clientId"])])
class OauthClientEntity : BaseEntity() {
    @Column(nullable = false)
    lateinit var clientId: String
    lateinit var applicationName: String
    var resourceIds: String? = null

    @Column(nullable = false)
    var clientSecret: String? = null
    var scope: String? = null

    @Column(nullable = false)
    var authorizedGrantTypes: String? = null
    var webServerRedirectUri: String? = null
    var authorities: String? = null
    var accessTokenValidity: Int? = null
    var refreshTokenValidity: Int? = null
    var additionalInformation: String? = null
    var autoApprove: String? = null

    /**
     * 客户端过期时间，比如应用于多店系统
     */
    var expirationDate: LocalDateTime? = null


}
