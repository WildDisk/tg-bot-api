import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val slf4j_version: String by project

plugins {
    kotlin("jvm") version "1.9.0"
    application
    kotlin("plugin.serialization") version "1.9.0"
}

group = "ru.wilddisk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("org.slf4j:slf4j-simple:$slf4j_version")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}