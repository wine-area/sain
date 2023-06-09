package io.nanfeng.user.biz.domain.role.dto

import java.io.Serializable

/**
 * A DTO for the {@link io.nanfeng.user.biz.domain.role.Role} entity
 */
data class RoleDto(
    val appId: String = "",
    val name: String = "",
    val code: String = "",
    val levels: Int = 0
) : Serializable