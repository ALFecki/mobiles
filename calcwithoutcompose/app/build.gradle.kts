plugins {
    alias(libs.plugins.androidApplication)
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.mobile.calc_without_compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mobile.calc_without_compose"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core.ktx)
    implementation(platform(libs.firebase.bom))

    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    implementation(platform(libs.kotlin.bom))
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.play.services.auth)
    implementation(libs.gson)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.analytics)

    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.logging.interceptor)
    implementation (libs.converter.scalars)
    implementation(libs.hilt.lifecycle.viewmodel)
    implementation (libs.lifecycle.viewmodel.ktx)
    implementation (libs.fragment.ktx)



}