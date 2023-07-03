package io.nanfeng.common.core.env

object Env {

        const val DEV = "dev"
        const val TEST = "test"
        const val PROD = "prod"

        val current: String = System.getProperty("spring.profiles.active") ?: DEV

        val isDev: Boolean = current == DEV

        val isTest: Boolean = current == TEST

        val isProd: Boolean = current == PROD
}