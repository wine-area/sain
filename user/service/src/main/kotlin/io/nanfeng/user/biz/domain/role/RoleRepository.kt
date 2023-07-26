package io.nanfeng.user.biz.domain.role;

import io.nanfeng.common.data.jpa.infrastructure.api.QBaseRepository
import io.nanfeng.user.biz.domain.role.entity.Role

interface RoleRepository : QBaseRepository<Role> {
}