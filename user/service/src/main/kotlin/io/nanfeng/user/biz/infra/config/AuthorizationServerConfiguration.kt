package io.nanfeng.user.biz.infra.config

import com.fasterxml.jackson.databind.Module
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.jackson2.SecurityJackson2Modules
import org.springframework.security.oauth2.server.authorization.jackson2.OAuth2AuthorizationServerJackson2Module
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class AuthorizationServerConfiguration {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        // 配置纯restful的安全配置
        // 无状态应用，完全依赖jwt进行认证
        // 无状态应用，不需要session
        // 无状态应用，不需要form表单登录
        // 无状态应用，不需要httpBasic
        // 无状态应用，不需要jee
        // 无状态应用，不需要x509
        // 所有授权通过method security进行控制

        return http.build()
    }

    @Bean
    fun securityAutoconfiguresCustomizer() = Jackson2ObjectMapperBuilderCustomizer {
        val securityModules: List<Module> = SecurityJackson2Modules.getModules(this::class.java.classLoader)
        it.modules(securityModules)
        it.modules(OAuth2AuthorizationServerJackson2Module())
    }
}