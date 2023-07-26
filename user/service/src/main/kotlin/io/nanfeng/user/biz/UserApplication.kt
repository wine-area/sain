package io.nanfeng.user.biz

import io.nanfeng.common.core.bootStrap
import io.nanfeng.common.data.jpa.infrastructure.api.EnableQuerydslRepositories
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableQuerydslRepositories
class UserApplication

fun main() {
    bootStrap<UserApplication>()
}
