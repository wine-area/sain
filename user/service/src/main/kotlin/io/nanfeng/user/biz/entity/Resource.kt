package io.nanfeng.user.biz.entity

import io.nanfeng.common.data.entity.BaseTreeEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.Hibernate

@Entity
@Table(name = "t_resource")
@org.hibernate.annotations.Table(appliesTo = "t_resource", comment = "资源信息")
data class Resource(
    var name: String = "",
    var code: String = "",
) : BaseTreeEntity<Resource>() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Resource

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , code = $code )"
    }
}