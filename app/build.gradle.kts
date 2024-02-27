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


    androidTestImplementation(libs.androidxComposeUiTestJunit4)
    androidTestImplementation(libs.androidxTestEspresso)
    androidTestImplementation(libs.androidxTestExt)
    androidTestImplementation(libs.daggerHiltAndroidTesting)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    api(libs.jetbrains.kotlinx.coroutines.android)
    api(libs.kotlinxCoroutines)
    debugImplementation(libs.androidxComposeUiTestManifest)
    debugImplementation(libs.androidxComposeUiTooling)
    implementation(libs.androidxActivity)
    implementation(libs.androidxCore)
    implementation(libs.androidxLifecycle)
    implementation(libs.coilCompose)
    implementation(libs.constraintlayoutCompose)
    implementation(libs.daggerHilt)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.logging.interceptor)
    implementation(libs.material3)
    implementation(libs.okhttp)
    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofitConverterGson)
    implementation(libs.room.ktx)
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    kapt(libs.daggerHiltCompiler)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.daggerHiltCompiler)
    kaptAndroidTest(libs.hilt.compiler)
    kaptTest(libs.daggerHiltCompiler)
    kaptTest(libs.hilt.compiler)
    testImplementation(libs.daggerHiltAndroidTesting)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.junit)
    //Room Db
    // Reference: https://dagger.dev/hilt/gradle-setup
    implementation(libs.room)
    kapt(libs.androidx.room.compiler)

}