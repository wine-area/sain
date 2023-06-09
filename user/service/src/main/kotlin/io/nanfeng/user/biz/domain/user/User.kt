package io.nanfeng.user.biz.domain.user

import com.fasterxml.jackson.annotation.JsonIgnore
import io.nanfeng.common.data.entity.BaseEntity
import io.nanfeng.user.biz.domain.org.Organization
import io.nanfeng.user.biz.domain.role.entity.Role
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.Lob
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import jakarta.persistence.Transient


@Entity
@Table(name = "t_user")
/* "用户信息" */
class User(


    @Column(nullable = false)
    /* "用户名称" */
    var username: String = "",

    @Column(length = 50, unique = true, nullable = false)
    /* "登录号" */
    var loginNo: String = "",

    @JsonIgnore
    @Column(nullable = false)
    var password: String = "",

    @Column(length = 20, unique = true, nullable = false)
    /* "手机号" */
    var mobile: String = "",

    @Column(nullable = false)
    /* "用户级别" */
    var levels: Int = 0,

    @Column(nullable = false)
    /* "是否启用" */
    var enabled: Boolean = false,

    @Lob
    @Column(length = 65535)
    /* "头像" */
    var avatar: String? = null,

    @Column(nullable = false)
    /* "序号" */
    var sort: Int = 0,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_organization_set",
        joinColumns = [JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )],
        inverseJoinColumns = [JoinColumn(
            name = "organization_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )]
    )
    /* "所属机构" */
    var organizationSet: MutableSet<Organization> = mutableSetOf(),

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_organization_mng_set",
        joinColumns = [JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )],
        inverseJoinColumns = [JoinColumn(
            name = "organization_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )]
    )
    /* "可管理的机构" */
    var organizationMngSet: MutableSet<Organization> = mutableSetOf(),

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinTable(
        name = "t_user_role_set",
        joinColumns = [JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )],
        inverseJoinColumns = [JoinColumn(
            name = "role_id",
            referencedColumnName = "id",
            foreignKey = ForeignKey(name = "none")
        )]
    )
    /* "所属角色" */
    var roleSet: MutableSet<Role> = mutableSetOf(),

    /* "最后修改密码时间" */
    var lastUpdatePasswordTime: Long = System.currentTimeMillis(),

    @Transient
    /* "密码是否过期" */
    var passwordExpire: Boolean = false,
) : BaseEntity()
