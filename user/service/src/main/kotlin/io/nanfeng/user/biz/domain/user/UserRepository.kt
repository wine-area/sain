package io.nanfeng.user.biz.domain.user;

import io.nanfeng.common.data.jpa.infrastructure.api.QBaseRepository
import java.util.*

interface UserRepository : QBaseRepository<User> {

    fun findByUsername(userName: String): User


    fun findByMobile(phone: String): Optional<User>

}