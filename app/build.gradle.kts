plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id("org.jetbrains.kotlin.kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.benjamin.horoscopoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.benjamin.horoscopoapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug"){
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    // Esta línea es necesaria para que funcione @Inject (viene del JSR-330)
    implementation("javax.inject:javax.inject:1")

    implementation("androidx.navigation:navigation-fragment:2.9.0")
    implementation("androidx.navigation:navigation-ui:2.9.0")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation("androidx.recyclerview:recyclerview:1.3.1")

    val versionCamera = "1.4.0"

    implementation("androidx.camera:camera-core:${versionCamera}")
    implementation("androidx.camera:camera-camera2:${versionCamera}")
    implementation("androidx.camera:camera-view:${versionCamera}")
    implementation("androidx.camera:camera-video:${versionCamera}")
    implementation("androidx.camera:camera-extensions:${versionCamera}")
    implementation("androidx.camera:camera-lifecycle:${versionCamera}")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}