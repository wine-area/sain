package io.nanfeng.user.biz.infra.mapper

import io.nanfeng.user.biz.domain.authentication.dto.UserDetailsDto
import io.nanfeng.user.biz.domain.user.User
import io.nanfeng.user.biz.infra.properties.UserProperties
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val userProperties: UserProperties
) {

    fun toDto(user: User): UserDetailsDto {
        return UserDetailsDto(
            id = user.id,
            username = user.username,
            password = user.password,
            loginNo = user.loginNo,
            mobile = user.mobile,
            levels = user.levels,
            enabled = user.enabled,
            avatar = user.avatar ?: "",
            sort = user.sort,
            lastUpdatePasswordTime = user.lastUpdatePasswordTime,
            roles = user.roleSet.map { RoleMapper.instance.toDto(it) }.toMutableList(),
            accountNonExpired = true,
            accountNonLocked = true,
            credentialsNonExpired = true
        )
    }

    fun toUserEntity(user: UserDetails): User {
        return User(
            username = user.username,
            password = user.password,
            loginNo = user.username,
            mobile = user.username,
            levels = 0,
            enabled = true,
            avatar = "",
            sort = 0,
            lastUpdatePasswordTime = System.currentTimeMillis()
        )
    }
}