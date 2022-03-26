plugins {
    id("com.android.application")
    id("kotlin-android-extensions")
    id("kotlin-android")
    id("com.squareup.sqldelight")
    id("kotlin-kapt")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.example.demotcs.android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        viewBinding = true
    }
}
val lifecycleVersion = "2.0.0"
dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation(project(":shared"))


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0-native-mt")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // LiveData and ViewModel



        // ViewModel and LiveData
        implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")

        // alternatively - just ViewModel
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    implementation("com.google.code.gson:gson:2.8.7")

    implementation(project(":shared"))
}