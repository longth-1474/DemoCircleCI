object Apps {
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val build_tools_version = "30.0.2"

    const val gradle = "4.0.1"
    const val kotlin = "1.4.0"
    const val appcompat = "1.0.2"
    const val constraint = "2.0.1"
    const val core_ktx = "1.3.1"

    const val ktlint = "0.36.0"
    const val detekt = "1.9.1"
    const val material = "1.2.0-alpha02"

    /* test */
    const val junit = "4.12"
    const val espresso = "3.2.0"
    const val androidx_test = "1.2.0"
    const val screengrab = "1.0.0"
}

object ClassPaths {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val support_design = "com.google.android.material:material:${Versions.material}"

    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
}

object Deps {
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"
    // other dependencies ...
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val atsl_runner = "androidx.test:runner:${Versions.androidx_test}"
    const val android_test = "androidx.test:rules:${Versions.androidx_test}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val screengrab = "tools.fastlane:screengrab:${Versions.screengrab}"
}

object Plugins {
    const val androidApp = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val detekt = "io.gitlab.arturbosch.detekt"
}