plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}

dependencies {
    api(platform(springLibs.spring.boot.bom))
    api(platform(springLibs.spring.cloud.bom))
    constraints {

    }
}