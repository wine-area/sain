plugins {
    id("spring-conventions")
}



dependencies {
    api(projects.common.core)
    api(project(":common:data"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    // spring-security
//    implementation("org.springframework.boot:spring-boot-starter-security")
    // querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    // kapt-queryDsl-kotlin
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    kapt(libs.spring.boot.configuration.processor)
    runtimeOnly(libs.database.h2)
    implementation(libs.hypersistence.utils)
    // mapstruct
    implementation(libs.mapstruct.core)
    kapt(libs.mapstruct.processor)
    // knife4j
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:+")
//     spring-oauthorization-server 需要oauth2的时候再整
//    implementation("org.springframework.security:spring-security-oauth2-authorization-server:1.1.0")
}