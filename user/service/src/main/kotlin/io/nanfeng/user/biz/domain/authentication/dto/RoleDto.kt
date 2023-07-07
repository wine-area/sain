package io.nanfeng.user.biz.domain.authentication.dto

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import java.io.Serializable

/**
 * A DTO for the {@link io.nanfeng.user.biz.domain.Role} entity
 */
data class RoleDto(val id: Long, val name: String, val code: String) : Serializable, GrantedAuthority {
    override fun getAuthority(): String {
        return code
    }
}