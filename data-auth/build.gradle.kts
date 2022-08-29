plugins {
    id ("com.android.library")
    id ("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdk = Project.compileSdk

    defaultConfig {
        minSdk = Project.minSdk
        targetSdk = Project.targetSdk
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Project.javaVersion
        targetCompatibility = Project.javaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain-auth"))
    implementation(project(":local-database"))
    implementation(Dependency.Network.gsonConverter)
    implementation(Dependency.Network.loggingInterceptor)
    implementation(Dependency.Network.retrofit)
    implementation(Dependency.Network.okhttp)

    implementation(Dependency.Coroutine.core)

    implementation(Dependency.DI.inject)

    implementation(Dependency.DI.hiltAndroid)
    kapt(Dependency.DI.hiltCompiler)

    implementation(Dependency.LocalStorage.room)
    implementation(Dependency.LocalStorage.roomCompiler)
    implementation(Dependency.LocalStorage.sharedPreference)
}