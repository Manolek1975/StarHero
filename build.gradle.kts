// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.androidx.navigation.safe.args) apply false
    alias(libs.plugins.google.devtools.ksp) apply false
    alias(libs.plugins.hiltPlugin) apply false
    alias(libs.plugins.room) apply false
}
