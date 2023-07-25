package io.nanfeng.common.core

import org.slf4j.LoggerFactory
import org.springframework.boot.runApplication

inline fun <reified T : Any> bootStrap() {
    val logger = LoggerFactory.getLogger(T::class.java)
    val launchApp = runApplication<T>()
    logger.atInfo().log {
        ApplicationStartupTraces.of(launchApp.environment)
    }
}