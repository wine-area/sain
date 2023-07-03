dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("springLibs") {
            from(files("../gradle/spring.versions.toml"))
        }
    }
}
