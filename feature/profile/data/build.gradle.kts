plugins {
    alias(libs.plugins.quiz.android.library)
    alias(libs.plugins.quiz.hilt)
    alias(libs.plugins.quiz.retrofit)
}

android {
    namespace = "com.quiz.feature.profile.data"
}

dependencies {
    implementation(projects.feature.profile.domain)
    implementation(projects.core.network)
    implementation(projects.core.common)
    implementation(projects.core.datasource.profile)
    implementation(projects.core.datastore)
}