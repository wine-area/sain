enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

plugins {
    id("com.gradle.enterprise").version("3.12.4")
}
dependencyResolutionManagement {
    versionCatalogs {

        create("springLibs") {
            from(files("./dependencies/spring.versions.toml"))
        }
    }
}
rootProject.name = "sain"
include(":common:core")
include(":common:data")
include(":common:web")
include(":dependencies")
include(":common:oops")
include(":common:dependencies")
include(":common:webflux")
include(":common:captcha-starter")
include("user")
include("user:api")
include("user:service")
