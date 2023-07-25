package io.nanfeng.common.core

import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import java.net.InetAddress
import java.net.UnknownHostException
import java.text.MessageFormat

private const val S = "-"

private const val getBREAK = "\n"

object ApplicationStartupTraces {
    private val SEPARATOR = S.repeat(58)
    private const val BREAK = getBREAK
    private val log = LoggerFactory.getLogger(ApplicationStartupTraces::class.java)
    fun of(environment: Environment): String {
        return ApplicationStartupTracesBuilder()
            .append(BREAK)
            .appendSeparator()
            .append(applicationRunningTrace(environment))
            .append(localUrl(environment))
            .append(externalUrl(environment))
            .append(profilesTrace(environment))
            .appendSeparator()
            .append(configServer(environment))
            .build()
    }

    private fun applicationRunningTrace(environment: Environment): String {
        val applicationName = environment.getProperty("spring.application.name")
        return if (applicationName.isNullOrBlank()) {
            "Application is running!"
        } else "Application '$applicationName' is running!"
    }

    private fun localUrl(environment: Environment): String? {
        return url("Local", "localhost", environment)
    }

    private fun externalUrl(environment: Environment): String? {
        return url("External", hostAddress(), environment)
    }

    private fun url(type: String, host: String, environment: Environment): String? {
        return if (notWebEnvironment(environment)) {
            null
        } else MessageFormat.format(
            "{0}: \t{1}://{2}:{3}{4}",
            type,
            protocol(environment),
            host,
            port(environment),
            contextPath(environment)
        )
    }

    private fun notWebEnvironment(environment: Environment): Boolean {
        return environment.getProperty("server.port").isNullOrBlank()
    }

    private fun protocol(environment: Environment): String {
        return if (noKeyStore(environment)) {
            "http"
        } else "https"
    }

    private fun noKeyStore(environment: Environment): Boolean {
        return environment.getProperty("server.ssl.key-store").isNullOrBlank()
    }

    private fun port(environment: Environment): String? {
        return environment.getProperty("server.port")
    }

    private fun profilesTrace(environment: Environment): String? {
        val profiles = environment.activeProfiles
        return if (profiles.isEmpty()) {
            null
        } else "Profile(s): \t" + java.lang.String.join(", ", *profiles)
    }

    private fun hostAddress(): String {
        try {
            return InetAddress.getLocalHost().hostAddress
        } catch (e: UnknownHostException) {
            log.warn("The host name could not be determined, using `localhost` as fallback")
        }
        return "localhost"
    }

    private fun contextPath(environment: Environment): String {
        val contextPath = environment.getProperty("server.servlet.context-path")
        return if (contextPath.isNullOrBlank()) {
            "/"
        } else contextPath
    }

    private fun configServer(environment: Environment): String? {
        val configServer = environment.getProperty("configserver.status")
        return if (configServer.isNullOrBlank()) {
            null
        } else "Config Server: $configServer$BREAK$SEPARATOR$BREAK"
    }

    private class ApplicationStartupTracesBuilder {
        private val trace = StringBuilder()
        fun appendSeparator(): ApplicationStartupTracesBuilder {
            trace.append(SEPARATOR).append(BREAK)
            return this
        }

        fun append(line: String?): ApplicationStartupTracesBuilder {
            if (line == null) {
                return this
            }
            trace.append(SPACER).append(line).append(BREAK)
            return this
        }

        fun build(): String {
            return trace.toString()
        }

        companion object {
            private const val SPACER = "  "
        }
    }
}
