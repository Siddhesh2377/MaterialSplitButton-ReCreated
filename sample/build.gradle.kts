plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  namespace = "com.dark.splitbutton.sample"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.dark.splitbutton.sample"
    minSdk = 29
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"
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

  buildFeatures{
    dataBinding = true
    viewBinding = true
  }
}

dependencies {
  implementation("com.github.Siddhesh2377:SplitButton:1.0.0")
}