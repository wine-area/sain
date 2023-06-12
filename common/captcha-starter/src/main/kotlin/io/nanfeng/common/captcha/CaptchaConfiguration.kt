package io.nanfeng.common.captcha

import io.nanfeng.common.captcha.api.CaptchaService
import io.nanfeng.common.captcha.repository.CaptchaRepository
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@EnableRedisRepositories(basePackageClasses = [CaptchaRepository::class])
class CaptchaConfiguration {

    @Bean
    fun captchaService(captchaRepository: CaptchaRepository): CaptchaService {
        return CaptchaService(captchaRepository)
    }
}