package io.nanfeng.common.captcha.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash("captcha")
data class CaptchaEntity(
    @Id
    val identify: String,
    val code: String,
    @TimeToLive
    val expireTime: Long
)
