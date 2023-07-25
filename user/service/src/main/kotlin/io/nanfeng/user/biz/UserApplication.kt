package io.nanfeng.user.biz

import io.nanfeng.common.core.bootStrap
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan
class UserApplication

fun main() {
    bootStrap<UserApplication>()
}
