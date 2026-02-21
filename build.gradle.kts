plugins {
    java
    id("org.springframework.boot") version "4.0.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.itq"
version = "0.0.1-SNAPSHOT"
description = "itq-test-problem"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-liquibase")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-liquibase-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform {
        val includeTagsProp = "includeTags"
        if (project.hasProperty(includeTagsProp)) {
            val tags = project.property(includeTagsProp).toString().split(',').toTypedArray()
            includeTags(*tags)
        }
        val excludeTagsProp = "excludeTags"
        if (project.hasProperty(excludeTagsProp)) {
            val tags = project.property(excludeTagsProp).toString().split(',').toTypedArray()
            excludeTags(*tags)
        }
    }
    testLogging {
        events("PASSED", "SKIPPED", "FAILED")
        showStandardStreams = true
        showCauses = true
    }
}
