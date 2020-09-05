import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.androidApp)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinExt)
    kotlin(Plugins.kotlinApt)
    id(Plugins.detekt).version(Versions.detekt)
}

buildscript {
    apply(from = "ktlint.gradle.kts")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Versions.build_tools_version)

    defaultConfig {
        applicationId = "com.example.democircleci"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        multiDexEnabled = true
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
        resConfigs("en")
        ndk {
            abiFilters("armeabi-v7a", "x86", "arm64-v8a", "x86_64")
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
        }
        getByName("release") {
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            isZipAlignEnabled = true
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

androidExtensions {
    isExperimental = true
}

detekt {
    config = files("$rootDir/config/detekt/detekt.yml")
    input = files("src/main/java")
    reports {
        html.enabled = true // observe findings in your browser with structure and code snippets
        xml.enabled = false // checkstyle like format mainly for integrations like Jenkins
        txt.enabled =
            false // similar to the console output, contains issue signature to manually edit baseline files
    }
}

dependencies {
    //import dependencies
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    implementation(Libs.support_design)
    implementation(Libs.core_ktx)
    implementation(Libs.constraint)

    //Kotlin Test
    testImplementation(TestLibs.junit)

    //Android test
    androidTestImplementation(TestLibs.atsl_runner)
    androidTestImplementation(TestLibs.android_test)
    androidTestImplementation(TestLibs.espresso_core)

    //Screenshot
    androidTestImplementation(TestLibs.screengrab)

}