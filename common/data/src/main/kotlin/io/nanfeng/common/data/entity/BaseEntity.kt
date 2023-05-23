package io.nanfeng.common.data.entity

import jakarta.persistence.MappedSuperclass
import org.springframework.data.jpa.domain.AbstractAuditable

@MappedSuperclass
open class BaseEntity : AbstractAuditable<Long, Long>() {
}