plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}
dependencies {
    api(projects.common.core)
    api(springLibs.spring.boot.starter.web)
}