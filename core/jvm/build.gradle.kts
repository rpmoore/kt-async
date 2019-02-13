apply(plugin = "java")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":core"))
    implementation(project(":buffer"))
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.25")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
}