plugins {
    kotlin("jvm") version "2.2.0-RC"
    id("com.gradleup.shadow") version "8.3.0"
}

group = "me.deadybbb"
version = "0.1.5"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

tasks.build {
    dependsOn("shadowJar")
}
