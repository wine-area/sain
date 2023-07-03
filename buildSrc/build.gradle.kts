plugins {
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(files(springLibs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen.plugin)
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
    implementation(libs.dokka.gradle.plugin)
}
