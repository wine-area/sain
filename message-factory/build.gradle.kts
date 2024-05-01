import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin-conventions")
    id("testing-conventions")
    id("dokka-conventions")
//  id("publishing-conventions") // If everything was configured correctly, you could use it to publish the artifacts. But it is not working with Spring as I thought.
    id("spring-conventions")
    id("org.jooq.jooq-codegen-gradle") version "3.19.6"
    idea
}

val loremVersion: String by rootProject.extra

dependencies {
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation(libs.bundles.lorem)
    implementation("org.jooq:jooq:3.19.6")
    jooqCodegen("mysql:mysql-connector-java:8.0.33")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}



tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
//        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jooq {
    configuration {
        jdbc {
            driver = "com.mysql.cj.jdbc.Driver"
//            url = "xx"
//            user = ""
//            password = ""
        }

        generator {
            name = "org.jooq.codegen.DefaultGenerator"
            database {
                name = "org.jooq.meta.mysql.MySQLDatabase"
                inputSchema = "crm_v5_api_fund"
            }
            generate {
                name = "org.jooq.codegen.KotlinGenerator"

                isDaos = true
                isPojosAsKotlinDataClasses = true
                isKotlinNotNullPojoAttributes = true
                isKotlinNotNullRecordAttributes = true
                isKotlinNotNullInterfaceAttributes = true
                isKotlinDefaultedNullablePojoAttributes = true

            }
            target {

                packageName = "cn.net.ysn.crm.v5.api.fund.jooq"
                directory = project.layout.buildDirectory.files("jooq").asPath
            }
        }
    }
}

idea {
    module {
        sourceDirs.add(file("build/generated/jooq"))
    }
}

kotlin {
    sourceSets {
        val main by getting {
            kotlin.srcDir("build/jooq")
        }
    }
}
