package io.nanfeng.user.biz.domain.role.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.nanfeng.common.data.jpa.domain.BaseEntity
import io.nanfeng.user.biz.domain.Resource.Resource
import io.nanfeng.user.biz.domain.user.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.Hibernate

/**
 *
 * @since JDK 11
 */
@Entity
@Table(name = "t_role")
/* "角色信息" */
data class Role(


    @Column(length = 36, nullable = false)
    /* "应用ID" */
    var appId: String = "",

    @Column(nullable = false)
    /* "角色名称" */
    var name: String = "",

    @Column(length = 100, nullable = false)
    /* "角色编码" */
    var code: String = "",

    @Column(nullable = false)
    /* "角色级别" */
    var levels: Int = 0,

    @Column(nullable = false)
    /* "序号" */
    var sort: Int = 0,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_role_set",
        joinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = ForeignKey(name="none"))],
        inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = ForeignKey(name="none"))]
    )
    var userSet: MutableSet<User> = mutableSetOf(),

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_role_resource_set",
        joinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = ForeignKey(name="none"))],
        inverseJoinColumns = [JoinColumn(name = "resource_id", referencedColumnName = "id", foreignKey = ForeignKey(name="none"))]
    )
    var menuSet: MutableSet<Resource> = mutableSetOf(),


    ) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Role

        return  id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }
}