plugins {
    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.kotlin.logging)
    api(projects.common.core)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.spring.boot.starter)
    implementation(libs.redisson.starter)
    implementation(libs.spring.boot.starter.data.redis)
}