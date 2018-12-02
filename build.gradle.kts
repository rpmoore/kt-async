plugins {
    kotlin("jvm") version "1.3.10" apply false
}

allprojects {
    group = "rpmoore.example"
    version = "0.0.1-SNAPSHOT"
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        "implementation"(kotlin("stdlib"))
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
    }
}
