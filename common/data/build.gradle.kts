plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(libs.spring.boot.starter.data.jpa)
    api(libs.kotlin.logging)
    implementation(libs.spring.boot.starter)
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    // kapt-queryDsl-kotlin
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

}