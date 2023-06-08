package io.nanfeng.user.biz.entity

import java.io.Serializable

/**
 * A DTO for the {@link io.nanfeng.user.biz.entity.Role} entity
 */
data class RoleDto(
    val appId: String = "",
    val name: String = "",
    val code: String = "",
    val levels: Int = 0
) : Serializable