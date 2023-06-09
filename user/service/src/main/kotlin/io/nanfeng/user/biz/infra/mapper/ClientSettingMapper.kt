package io.nanfeng.user.biz.infra.mapper

import io.nanfeng.user.biz.domain.client.entity.OAuth2ClientSettingsEntity
import org.springframework.security.oauth2.jose.jws.JwsAlgorithm
import org.springframework.security.oauth2.jose.jws.MacAlgorithm
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings
import org.springframework.util.StringUtils

fun OAuth2ClientSettingsEntity.toClientSettings(): ClientSettings {
    val builder = ClientSettings.builder()
        .requireProofKey(isRequireProofKey)
        .requireAuthorizationConsent(isRequireAuthorizationConsent)
    val signatureAlgorithm = SignatureAlgorithm.from(signingAlgorithm)
    val jwsAlgorithm: JwsAlgorithm? = signatureAlgorithm ?: MacAlgorithm.from(signingAlgorithm)
    if (jwsAlgorithm != null) {
        builder.tokenEndpointAuthenticationSigningAlgorithm(jwsAlgorithm)
    }
    if (StringUtils.hasText(jwkSetUrl)) {
        builder.jwkSetUrl(jwkSetUrl)
    }
    return builder.build()
}

fun ClientSettings.toOauth2ClientSetting(): OAuth2ClientSettingsEntity {
    val clientSettings = this
    val oAuth2ClientSettingsEntity = OAuth2ClientSettingsEntity()
    oAuth2ClientSettingsEntity.isRequireProofKey = clientSettings.isRequireProofKey
    oAuth2ClientSettingsEntity.isRequireAuthorizationConsent = clientSettings.isRequireAuthorizationConsent
    oAuth2ClientSettingsEntity.jwkSetUrl = clientSettings.jwkSetUrl
    val algorithm = clientSettings.tokenEndpointAuthenticationSigningAlgorithm
    if (algorithm != null) {
        oAuth2ClientSettingsEntity.signingAlgorithm = algorithm.name
    }
    return oAuth2ClientSettingsEntity
}