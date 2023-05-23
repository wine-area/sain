plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.kotlin.logging)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.spring.boot.starter)
    // compileOnly spring-webmvc
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.springframework.boot:spring-boot-starter-webflux")
}