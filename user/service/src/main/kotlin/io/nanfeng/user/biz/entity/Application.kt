//package io.nanfeng.user.biz.entity
//
//import jakarta.persistence.Column
//import jakarta.persistence.Entity
//import jakarta.persistence.Table
//import org.hibernate.Hibernate
//import org.springframework.data.jpa.domain.AbstractAuditable
//import java.util.*
//
//
//@Entity
//@Table(name = "t_application")
//@org.hibernate.annotations.Table(appliesTo = "t_application", comment = "应用信息")
///* "应用信息" */
//data class Application(
//    val clientId: String = UUID.randomUUID().toString(),
//    val clientName: String,
//
//    ) : AbstractAuditable<User, Long>() {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
//        other as Application
//
//        return id == other.id
//    }
//
//    override fun hashCode(): Int = javaClass.hashCode()
//
//
//}