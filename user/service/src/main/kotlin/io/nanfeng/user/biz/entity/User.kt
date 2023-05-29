package io.nanfeng.user.biz.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.nanfeng.common.data.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.data.jpa.domain.AbstractAuditable


@Entity
@Table(name = "t_user")
@org.hibernate.annotations.Table(appliesTo = "t_user", comment = "用户信息")
/* "用户信息" */
data class User(


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
) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $username )"
    }
}
