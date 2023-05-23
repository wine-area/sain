package io.nanfeng.user.biz.infra.mapper

import io.nanfeng.user.biz.domain.authentication.dto.RoleDto
import io.nanfeng.user.biz.entity.Role
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface RoleMapper {
    companion object {
        val instance = Mappers.getMapper(RoleMapper::class.java)
    }

    fun toDto(role: Role): RoleDto
}