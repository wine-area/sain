package io.nanfeng.common.core.captcha.domain

abstract class AbstractCaptchaGenerator(
    override val sourceChars: List<Char> = ('0'..'9') + ('a'..'z') + ('A'..'Z')
) : CaptchaGenerator {


    override fun generate(length: Int): String {
        return (1..length).map { sourceChars.random() }.joinToString("")
    }
}