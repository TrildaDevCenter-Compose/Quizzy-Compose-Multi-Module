plugins {
    alias(libs.plugins.quiz.android.library)
    alias(libs.plugins.quiz.hilt)
}

android {
    namespace = "com.canerture.core.datastore"
}

dependencies {
    implementation(libs.datastore)
}