plugins {
    kotlin("multiplatform") version "1.3.21" apply false
}

allprojects {
    group = "rpmoore.example"
    version = "0.0.1-SNAPSHOT"
}

subprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        "implementation"(kotlin("stdlib"))
        "implementation"(kotlin("reflect"))
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.1.1")
    }
}
