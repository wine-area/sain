package io.nanfeng.user.biz.domain.client.entity

import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings
import java.io.Serializable
import java.time.Duration
import java.util.*


class OAuth2TokenSettingsEntity : Serializable {
    lateinit var clientId: String
    lateinit var accessTokenTimeToLive: Duration
    var tokenFormat: String = OAuth2TokenFormat.SELF_CONTAINED.value
    var isReuseRefreshTokens = true
    var refreshTokenTimeToLive: Duration = Duration.ofHours(1)
    var idTokenSignatureAlgorithm: String = SignatureAlgorithm.RS256.name
    fun toTokenSettings(): TokenSettings {
        return TokenSettings.builder()
            .accessTokenTimeToLive(
                Optional.ofNullable(accessTokenTimeToLive)
                    .orElse(Duration.ofMinutes(5))
            )
            .accessTokenFormat(OAuth2TokenFormat(tokenFormat))
            .reuseRefreshTokens(isReuseRefreshTokens)
            .refreshTokenTimeToLive(refreshTokenTimeToLive)
            .idTokenSignatureAlgorithm(SignatureAlgorithm.from(idTokenSignatureAlgorithm))
            .build()
    }


    companion object {
        private const val serialVersionUID = -7077164876986169673L


        fun fromTokenSettings(tokenSettings: TokenSettings): OAuth2TokenSettingsEntity {
            val oAuth2TokenSettingsEntity = OAuth2TokenSettingsEntity()
            oAuth2TokenSettingsEntity.accessTokenTimeToLive = tokenSettings.accessTokenTimeToLive
            oAuth2TokenSettingsEntity.tokenFormat = tokenSettings.accessTokenFormat.value
            oAuth2TokenSettingsEntity.isReuseRefreshTokens = tokenSettings.isReuseRefreshTokens
            oAuth2TokenSettingsEntity.refreshTokenTimeToLive = tokenSettings.refreshTokenTimeToLive
            oAuth2TokenSettingsEntity.idTokenSignatureAlgorithm = tokenSettings.idTokenSignatureAlgorithm.getName()
            return oAuth2TokenSettingsEntity
        }
    }
}
