package io.nanfeng.common.captcha.repository

import io.nanfeng.common.captcha.entity.CaptchaEntity
import org.springframework.data.repository.CrudRepository


interface CaptchaRepository : CrudRepository<CaptchaEntity, String> {
}