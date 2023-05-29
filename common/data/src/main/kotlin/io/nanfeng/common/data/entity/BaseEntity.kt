package io.nanfeng.common.data.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.jpa.domain.AbstractAuditable
import java.time.Instant

@MappedSuperclass
open class BaseEntity {
    @Id
    @GeneratedValue
    var id: Long = 0
    var createdBy: Long = 0
    var lastModifiedBy: Long = 0
    var createdDate: Instant = Instant.now()
    var lastModifiedDate: Instant = Instant.now()
}