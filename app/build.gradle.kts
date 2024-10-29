plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)

    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.developerx.climatico"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.developerx.climatico"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildToolsVersion = "34.0.0"

    buildFeatures {
        buildConfig = true
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
    packagingOptions.resources.excludes += setOf(
        "META-INF/DEPENDENCIES",
        "META-INF/LICENSE",
        "META-INF/LICENSE.txt",
        "META-INF/license.txt",
        "META-INF/NOTICE",
        "META-INF/NOTICE.txt",
        "META-INF/notice.txt",
        "META-INF/ASL2.0",
        "META-INF/*.kotlin_module"
    )
}

kapt {
    correctErrorTypes = true
}


dependencies {

    /* Projects */

    implementation(project(":features:models"))
    implementation(project(":models"))
    implementation(project(":core:common"))
    implementation(project(":core:core-data"))
    implementation(project(":core:core-domain"))
    implementation(project(":base-android"))

    implementation(project(":features:cities-module:city-ui"))
    implementation(project(":features:cities-module:city-data"))
    implementation(project(":features:cities-module:city-domain"))

    implementation(project(":features:weather-module:selected-city-weather-broadcast-data"))
    implementation(project(":features:weather-module:selected-city-weather-broadcast-domain"))
    implementation(project(":features:weather-module:selected-city-weather-broadcast-ui"))

    implementation(project(":features:weather-history-module:historical-broadcast-data"))
    implementation(project(":features:weather-history-module:historical-broadcast-domain"))
    implementation(project(":features:weather-history-module:historical-broadcast-ui"))


    implementation( libs.accompanist.pager)
    implementation( libs.accompanist.pager.indicators)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.coil)
    implementation(libs.navhost)
    implementation(libs.androidx.compose.material)
    implementation(libs.gson)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    kapt(libs.hilt.compiler)
    implementation(libs.timber)

    //permissions
    implementation(libs.accompanist.permissions)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation (libs.auto.service)
}
