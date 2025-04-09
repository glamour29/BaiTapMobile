plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.btvn_tuan03_jetpackcompose_letrieuduy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.btvn_tuan03_jetpackcompose_letrieuduy"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation("androidx.compose.ui:ui-text:1.3.0")  // Để sử dụng SpanStyle và TextStyle
    implementation("androidx.compose.ui:ui-text-google-fonts:1.3.0")
    implementation(libs.androidx.ui.tooling.preview)

    // Dành cho SpanStyle và các text style khác
    implementation("androidx.compose.ui:ui-text:1.3.0") // Cần thiết cho SpanStyle
    implementation("androidx.compose.ui:ui-text-google-fonts:1.3.0") // Thư viện Google Fonts (nếu cần)

    implementation(libs.androidx.material3)

    implementation("androidx.navigation:navigation-compose:2.4.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(platform("androidx.compose:compose-bom:2023.1.0"))
}
