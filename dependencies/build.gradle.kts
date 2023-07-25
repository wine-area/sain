plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
}

dependencies {
    api(enforcedPlatform(springLibs.spring.boot.bom))
    api(enforcedPlatform(springLibs.spring.cloud.bom))
    constraints {
    }
}