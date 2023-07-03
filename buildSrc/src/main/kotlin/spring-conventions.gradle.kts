import java.time.Instant

plugins {
    id("java-conventions")
    id("library-conventions")

    // Classes annotated with @Configuration, @Controller, @RestController, @Service or @Repository are automatically opened
    // https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support
    kotlin("plugin.spring")

    // Allows to package executable jar or war archives, run Spring Boot applications, and use the dependency management
    // https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/
    id("org.springframework.boot")
}

apply(plugin = "org.jetbrains.kotlin.plugin.spring")

apply(plugin = "org.springframework.boot")

apply(plugin = "io.spring.dependency-management")



springBoot {
    // Creates META-INF/build-info.properties for Spring Boot Actuator
    buildInfo {
        properties {
            additional.set(
                mapOf(
                    "env" to project.properties["env"],
                    "creationTime" to Instant.now().toString()
                )
            )

        }
    }
}

