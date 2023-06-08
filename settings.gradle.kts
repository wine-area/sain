plugins {
    id("com.gradle.enterprise").version("3.12.4")
}
rootProject.name = "sain"
include(":common:core")
include(":common:data")
include(":common:web")
include(":common:webflux")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

if (!System.getenv("CI").isNullOrEmpty() && !System.getenv("BUILD_SCAN_TOS_ACCEPTED").isNullOrEmpty()) {
    gradleEnterprise {
        buildScan {
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
            tag("CI")
        }
    }
}
include("user")
include("user:api")
include("user:service")
