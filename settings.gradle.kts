rootProject.name = "TODO_List"

include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        kotlin("jvm").version("1.8.20")
        kotlin("multiplatform").version("1.8.20")
        kotlin("android").version("1.8.20")

        id("com.android.application").version("7.4.2")
        id("com.android.library").version("7.4.2")

        id("org.jetbrains.compose").version("1.4.0")
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    versionCatalogs {
        create("libs") {
            from(files("libs.catalogs.toml"))
        }
    }

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
