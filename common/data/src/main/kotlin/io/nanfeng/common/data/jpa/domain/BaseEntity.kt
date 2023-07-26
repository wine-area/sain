package io.nanfeng.common.data.jpa.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@MappedSuperclass
open class BaseEntity {
    @Id
    @GeneratedValue
    var id: Long = 0
    var createdBy: Long = 0
    var lastModifiedBy: Long = 0

    @CreationTimestamp
    var createdDate: Instant = Instant.now()

    @UpdateTimestamp
    var lastModifiedDate: Instant = Instant.now()
}