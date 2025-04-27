plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  `maven-publish`
}

group = "com.dark"
version = libs.versions.lib.version.get()

android {
  namespace = "com.dark.splitbutton"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  buildToolsVersion = libs.versions.android.buildToolsVersion.get()

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlin {
    jvmToolchain(11)
  }
}

afterEvaluate {
  publishing {
    publications {
      register("mavenRelease", MavenPublication::class) {
        groupId = "com.dark"
        artifactId = "SplitButton"
        version = libs.versions.lib.version.get()
        from(components["release"])
      }
    }
  }
}
