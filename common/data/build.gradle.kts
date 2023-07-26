plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.spring.boot.starter.data.jpa)
    api(libs.kotlin.logging)
    implementation(libs.spring.boot.starter)
    implementation(libs.querydsl.jpa)
    // kapt-queryDsl-kotlin
    kapt(libs.querydsl.apt)
}