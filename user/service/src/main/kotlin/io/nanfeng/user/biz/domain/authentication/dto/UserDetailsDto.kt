//package io.nanfeng.user.biz.domain.authentication.dto
//
//import org.springframework.security.core.userdetails.UserDetails
//import java.io.Serializable
//
///**
// * A DTO for the {@link io.nanfeng.user.biz.domain.User} entity
// */
//class UserDetailsDto(
//    val id: Long,
//    private val username: String,
//    private val password: String,
//    val loginNo: String,
//    val mobile: String,
//    val levels: Int,
//    val enabled: Boolean,
//    val avatar: String,
//    val sort: Int,
//    val lastUpdatePasswordTime: Long,
//    val roles: MutableList<RoleDto>,
//    val accountNonExpired: Boolean,
//    val accountNonLocked: Boolean,
//    val credentialsNonExpired: Boolean,
//) : UserDetails, Serializable {
//    override fun getAuthorities() = roles
//
//    override fun getPassword() = password
//    override fun getUsername() = username
//
//    override fun isAccountNonExpired(): Boolean = accountNonExpired
//
//    override fun isAccountNonLocked(): Boolean = accountNonLocked
//
//    override fun isCredentialsNonExpired() = credentialsNonExpired
//    override fun isEnabled(): Boolean = enabled
//}