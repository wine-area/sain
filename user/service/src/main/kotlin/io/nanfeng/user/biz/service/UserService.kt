package io.nanfeng.user.biz.service

import io.nanfeng.user.biz.entity.User
import io.nanfeng.user.biz.repo.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUserInfo(): MutableIterable<User> {
        return userRepository.findAll()
    }

    fun getUserInfoById(id: Long?,userName: String?): User {
//        return userRepository.findById(id).get()
        TODO()
    }

    fun getUserInfoByUserName(userName: String): User {
        TODO()
    }
}