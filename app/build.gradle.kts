plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.iti.oishi"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.iti.oishi"
        minSdk = 28
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.glide)
    implementation(libs.lottie)
    implementation (libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.room.runtime)
    implementation(libs.annotation)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(platform(libs.firebase.bom))
    implementation (libs.firebase.auth)
    implementation (libs.firebase.database)
    implementation(libs.firebase.firestore)
    implementation(libs.play.services.auth.v2130)
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)
    implementation (libs.navigation.fragment.ktx)
    implementation (libs.navigation.ui.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    annotationProcessor(libs.room.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}