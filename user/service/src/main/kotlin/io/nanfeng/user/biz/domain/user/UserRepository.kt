package io.nanfeng.user.biz.domain.user;

import io.nanfeng.common.data.repo.QBaseRepository
import io.nanfeng.user.biz.domain.user.User
import java.util.*

interface UserRepository : QBaseRepository<User> {

    fun findByUsername(userName: String): User


    fun findByMobile(phone: String): Optional<User>

}