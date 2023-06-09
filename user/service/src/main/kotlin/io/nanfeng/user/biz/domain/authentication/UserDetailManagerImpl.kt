package io.nanfeng.user.biz.domain.authentication

import io.nanfeng.user.biz.infra.mapper.UserMapper
import io.nanfeng.user.biz.domain.user.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class UserDetailManagerImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        return userMapper.toDto(user)
    }

}