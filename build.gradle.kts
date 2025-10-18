val mcpVersion = "0.7.2"
val slf4jVersion = "2.0.17"
val ktorVersion = "3.3.1"

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

group = "net.tmpa.mcp.learn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.modelcontextprotocol:kotlin-sdk:${mcpVersion}")
    implementation("org.slf4j:slf4j-nop:${slf4jVersion}")
    implementation("io.ktor:ktor-client-core:${ktorVersion}")
    implementation("io.ktor:ktor-client-cio:${ktorVersion}")
    implementation("io.ktor:ktor-client-content-negotiation:${ktorVersion}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktorVersion}")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

kotlin {
    jvmToolchain(24)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}
