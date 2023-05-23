plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.kotlin.logging)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    // kapt-queryDsl-kotlin
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}