package io.nanfeng.user.biz.domain.client.entity

import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable


@Entity
@Table(name = "oauth2_scope")
class OAuth2ScopeEntity : BaseEntity(), Serializable {

    lateinit var scope: String
    lateinit var description: String

}
