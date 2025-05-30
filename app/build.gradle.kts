plugins {
    alias(libs.plugins.quiz.android.application)
    alias(libs.plugins.quiz.android.application.compose)
    alias(libs.plugins.quiz.android.firebase)
    alias(libs.plugins.quiz.hilt)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.canerture.quizappcompose"
    defaultConfig {
        applicationId = "com.canerture.quizappcompose"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.network)
    implementation(projects.core.datasource.logout)
    implementation(projects.core.connectivity)

    implementation(projects.feature.welcome.data)
    implementation(projects.feature.splash.data)
    implementation(projects.feature.login.data)
    implementation(projects.feature.register.data)
    implementation(projects.feature.home.data)
    implementation(projects.feature.category.data)
    implementation(projects.feature.search.data)
    implementation(projects.feature.detail.data)
    implementation(projects.feature.quiz.data)
    implementation(projects.feature.leaderboard.data)
    implementation(projects.feature.profile.data)
    implementation(projects.feature.editprofile.data)
    implementation(projects.feature.favorites.data)

    implementation(projects.navigation)
    implementation(libs.navigation.compose)
}