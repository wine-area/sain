package io.nanfeng.user.biz.domain.client.entity

import java.io.Serializable


class OAuth2ClientSettingsEntity : Serializable {
    lateinit var clientId: String
    var isRequireProofKey = false
    var isRequireAuthorizationConsent = false
    lateinit var jwkSetUrl: String
    lateinit var signingAlgorithm: String


    companion object {
        private const val serialVersionUID = -7956711700342643896L
    }
}


