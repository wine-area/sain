package io.nanfeng.user.biz.domain.client.repository;

import io.nanfeng.common.data.repo.QBaseRepository
import io.nanfeng.user.biz.domain.client.entity.RegisteredClientEntity

interface RegisteredClientRepository : QBaseRepository<RegisteredClientEntity> {
    fun findByClientId(clientId: String): RegisteredClientEntity?
}
