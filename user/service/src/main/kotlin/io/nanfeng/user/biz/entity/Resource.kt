package io.nanfeng.user.biz.entity

import io.nanfeng.common.data.entity.BaseTreeEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "t_resource")
class Resource(
    var name: String = "",
    var code: String = "",
) : BaseTreeEntity<Resource>()