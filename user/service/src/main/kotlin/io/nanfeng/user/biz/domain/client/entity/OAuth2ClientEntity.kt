//package io.nanfeng.user.biz.domain.client.entity
//
//import io.hypersistence.utils.hibernate.type.json.JsonType
//import io.nanfeng.common.data.jpa.domain.BaseEntity
//import jakarta.persistence.Column
//import jakarta.persistence.Entity
//import jakarta.persistence.Table
//import org.hibernate.annotations.Type
//import java.io.Serializable
//import java.time.Instant
//import java.util.*
//
//
//@Entity
//@Table(name = "oauth2_client")
//class OAuth2ClientEntity : BaseEntity(), Serializable {
//
//
//    @Column(name = "client_id", unique = true, updatable = false)
//    lateinit var clientId: String
//
//    lateinit var clientIdIssuedAt: Instant
//
//    lateinit var clientSecret: String
//
//    lateinit var clientSecretExpiresAt: Instant
//
//    lateinit var clientName: String
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    var clientAuthenticationMethods: Set<String> = emptySet()
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    var authorizationGrantTypes: Set<String> = emptySet()
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    var redirectUris: Set<String> = emptySet()
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    var scopes: Set<String> = emptySet()
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    lateinit var clientSettings: OAuth2ClientSettingsEntity
//
//    @Type(JsonType::class)
//    @Column(columnDefinition = "json")
//    lateinit var tokenSettings: OAuth2TokenSettingsEntity
//
//
//    companion object {
//        private const val serialVersionUID = 8481969837769002598L
//
//    }
//}
