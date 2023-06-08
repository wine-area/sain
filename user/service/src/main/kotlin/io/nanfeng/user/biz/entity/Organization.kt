package io.nanfeng.user.biz.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.nanfeng.common.data.entity.BaseTreeEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.Hibernate

@Entity
@Table(
    name = "t_organization", indexes = [
        Index(columnList = "area"),
        Index(columnList = "code"),
        Index(columnList = "parentId")]
)
/* "机构信息" */
data class Organization(

    /* "机构名称" */
    @Column(nullable = false)
    var name: String = "",

    /* "机构区域" */
    @Column(length = 100, nullable = false)
    var area: String = "",

    /* "机构编码" */
    @Column(length = 100, nullable = false)
    var code: String = "",

    /* "序号" */
    @Column(nullable = false)
    var sort: Int = 0,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_organization_set",
        joinColumns = [JoinColumn(
            name = "organization_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    var userSet: MutableSet<User> = mutableSetOf(),

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_organization_mng_set",
        joinColumns = [JoinColumn(
            name = "organization_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")]
    )
    var adminUserSet: MutableSet<User> = mutableSetOf()
) : BaseTreeEntity<Organization>() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Organization

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , code = $code )"
    }

}