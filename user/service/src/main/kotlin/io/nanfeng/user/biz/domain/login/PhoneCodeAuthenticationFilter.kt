package io.nanfeng.user.biz.domain.login

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.web.authentication.AuthenticationConverter
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationFilter
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

class PhoneCodeAuthenticationFilter(
    phoneCodeAuthenticationManager: AuthenticationManager,
    phoneCodeAuthenticationConverter: AuthenticationConverter,
    successHandler: AuthenticationSuccessHandler,
    failureHandler: AuthenticationFailureHandler
) : AuthenticationFilter(phoneCodeAuthenticationManager, phoneCodeAuthenticationConverter) {
    init {
        this.successHandler = successHandler
        this.failureHandler = failureHandler
    }
}