import org.gradle.plugins.ide.idea.model.IdeaModel

plugins {
//    id("testing-conventions")
    id("dokka-conventions")
    id("library-conventions")
    idea
}
dependencies {
    api(libs.kotlin.logging)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.spring.boot.starter)
    compileOnly(springLibs.spring.boot.starter.web)
}

configure<IdeaModel> {
    module {
        resourceDirs.add(rootProject.file("i18n"))
    }
}

sourceSets {
    main {
        resources {
            srcDir(rootProject.file("i18n"))
        }
    }
}
