package io.nanfeng.common.core.captcha

/**
 * 验证码生成器
 */
interface CaptchaGenerator {

    val sourceChars: List<Char>

    companion object {
        const val LENGTH: Int = 6
    }

    /**
     * 生成验证码
     * @return 验证码
     */
    fun generate(length: Int = LENGTH): String

}