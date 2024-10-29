plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.developerx.historical_weather_broadcast_data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildToolsVersion = "34.0.0"
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // HILT
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //ROOM dependencies
    implementation( libs.androidx.room.ktx)
    implementation( libs.androidx.room.rxjava2)
    kapt(libs.androidx.room.compiler)

    implementation(project(":features:models"))
    implementation(project(":core:common"))
    implementation(project(":core:core-data"))

    implementation(project(":features:weather-history-module:historical-broadcast-domain"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
