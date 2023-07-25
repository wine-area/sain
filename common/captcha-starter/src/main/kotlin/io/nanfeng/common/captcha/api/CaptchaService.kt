package io.nanfeng.common.captcha.api

import io.nanfeng.common.captcha.entity.CaptchaEntity
import io.nanfeng.common.captcha.repository.CaptchaRepository
import io.nanfeng.common.core.captcha.domain.SimpleCaptchaGenerator

class CaptchaService(
    private val captchaRepository: CaptchaRepository
) {


    fun generateCodeByIdentify(identify: String): String {
        val generate = SimpleCaptchaGenerator.generate()
        return CaptchaEntity(
            identify = identify,
            code = generate,
            expireTime = 60 * 5
        ).let {
            captchaRepository.save(it)
        }.code
    }

    fun verifyCodeByIdentify(identify: String, code: String): Boolean {
        captchaRepository.findById(identify).let {
            return it.isPresent && it.get().code == code
        }
    }
}