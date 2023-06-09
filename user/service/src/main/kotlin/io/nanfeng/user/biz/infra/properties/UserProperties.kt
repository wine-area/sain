package io.nanfeng.user.biz.infra.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import java.time.Duration

@ConfigurationProperties(prefix = "user")
data class UserProperties @ConstructorBinding constructor(
    /**
     * 用户过期时间
     */
    val userExpireDuration: Duration,
    /**
     * 用户密码过期时间
     */
    val maxUnModifyPasswordDuration: Duration,
) {
}