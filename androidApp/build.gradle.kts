plugins {
    id("com.android.application")
    id("org.jetbrains.compose")
    kotlin("android")
}

android {
    namespace = "app.isfa.todolist.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "app.isfa.todolist.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Android
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.corektx)

    // Shared
    implementation(project(":shared"))

    // Compose
    implementation(libs.androidx.compose.activity)

    // Compose Multiplatform (but compatible for androidx)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.preview)
}