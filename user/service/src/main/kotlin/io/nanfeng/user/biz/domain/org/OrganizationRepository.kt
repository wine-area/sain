package io.nanfeng.user.biz.domain.org;

import io.nanfeng.common.data.jpa.infrastructure.api.QBaseRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : QBaseRepository<Organization> {
}