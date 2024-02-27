plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.org.test.randomusersapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.org.test.randomusersapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation(libs.androidxCore)
    implementation(libs.androidxLifecycle)
    implementation(libs.androidxActivity)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidxTestExt)
    androidTestImplementation(libs.androidxTestEspresso)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(libs.daggerHilt)
    kapt(libs.hilt.compiler)

    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)

    implementation(libs.hiltNavigationCompose)

    //okhttp
    implementation(libs.okhttp)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.logging.interceptor)

    //Images Compose
    implementation(libs.coilCompose)

    //Room Db
    // Reference: https://dagger.dev/hilt/gradle-setup
    implementation(libs.room)
    kapt(libs.androidx.room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)

    //Kotlin Components and Kotlin Coroutines
    api(libs.kotlinxCoroutines)
    api(libs.jetbrains.kotlinx.coroutines.android)

    //ConstraintLayout
    implementation(libs.constraintlayoutCompose)
}