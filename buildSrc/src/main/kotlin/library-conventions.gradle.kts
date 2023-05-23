import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("kotlin-conventions")
    kotlin("plugin.spring")
}
// https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()
dependencies {
    implementation(enforcedPlatform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(libs.spring.cloud.bom)
    constraints {

    }
}

