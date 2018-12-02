/*
 * ****************************************************************************
 *   Copyright 2014-2018 Spectra Logic Corporation. All Rights Reserved.
 * ***************************************************************************
 */

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
        mavenCentral()
    }

    dependencies {
        classpath("com.github.ben-manes:gradle-versions-plugin:0.17.0")
    }
}

plugins {
    base
    java apply false
    kotlin("jvm") version "1.3.10" apply false
    id("org.ajoberstar.grgit") version "2.2.1"
}

allprojects {
    group = "rpmoore.ktasync"
    version = "0.0.1-SNAPSHOT"
}

subprojects {
    apply(plugin = "com.github.ben-manes.versions")
    apply(plugin = "java")
    apply(plugin = "kotlin")

    ext {
        this["sfl4jVersion"] = "1.7.25"
        this["kotlinCoroutineVersion"] = "1.0.1"
    }

    java {

    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        "implementation"(kotlin("stdlib"))
        "implementation"(group = "org.slf4j", name = "slf4j-api", version = extra["slf4jVersion"] as String)
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:${extra["kotlinCoroutineVersion"] as String}")

        /*
        testCompile(group: 'org.slf4j', name: 'slf4j-simple', version: "$slf4jVersion")
        testCompile("junit:junit:$junitVersion")
        testCompile("org.hamcrest:hamcrest-core:$hamcrestVersion")
        testCompile("org.mockito:mockito-core:$mockitoVersion")
        testCompile("org.assertj:assertj-core:$assertjVersion")
        testCompile("com.nhaarman:mockito-kotlin:$mockitoKotlinVersion")
        */
    }
}
