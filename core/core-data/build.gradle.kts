plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.developerx.core.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        defaultConfig {
            // Default configuration options
            buildConfigField("String", "BASE_URL", "\"https://api.openweathermap.org/data/2.5/\"")
            buildConfigField("String", "ICONS_URL", "\"https://openweathermap.org/img/wn/\"")
            buildConfigField("String", "APP_KEY", "\"521771166646bed44b72d66075166ff1\"")
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
    }
}


dependencies {

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.bundles.kotlin)
    implementation(libs.coroutinesCore)

    implementation(project(":core:common"))

    implementation(libs.bundles.network)
    implementation(libs.ok2curl)

    implementation(libs.hilt.android)
    implementation(project(":base-android"))
    kapt(libs.hilt.compiler)
    implementation(libs.timber)
    // chucker
    debugImplementation(libs.chucker)
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
