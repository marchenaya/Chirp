package com.marchenaya.chirp.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

private const val VERSION_COMPILE_SDK = "projectCompileSdkVersion"
private const val VERSION_MIN_SDK = "projectMinSdkVersion"
private const val OPT_IN_EXPERIMENTAL_COROUTINES =
    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"

internal fun Project.configureKotlinAndroid(
    applicationExtension: ApplicationExtension
) {
    with(applicationExtension) {
        compileSdk = libs.findVersion(VERSION_COMPILE_SDK).get().toString().toInt()

        defaultConfig.minSdk = libs.findVersion(VERSION_MIN_SDK).get().toString().toInt()

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            isCoreLibraryDesugaringEnabled = true
        }

        configureKotlin()

        dependencies {
            CORE_LIBRARY_DESUGARING(libs.findLibrary(LIBRARY_DESUGAR_JDK_LIBS).get())
        }
    }
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)

            freeCompilerArgs.add(OPT_IN_EXPERIMENTAL_COROUTINES)
        }
    }
}