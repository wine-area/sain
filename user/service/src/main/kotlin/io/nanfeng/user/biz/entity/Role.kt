package io.nanfeng.user.biz.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.Hibernate
import org.springframework.data.jpa.domain.AbstractAuditable

/**
 *
 * @since JDK 11
 */
@Entity
@Table(name = "t_role")
@org.hibernate.annotations.Table(appliesTo = "t_role", comment = "角色信息")
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


    ) : AbstractAuditable<User, Long>() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Role

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }
}