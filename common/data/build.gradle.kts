plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.kotlin.logging)
    api(libs.spring.boot.starter.data.jpa)
    api(libs.redisson.starter)
    implementation(libs.spring.boot.starter)
    api(libs.querydsl.jpa)
    kapt(libs.querydsl.apt)
}