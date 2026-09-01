package com.marchenaya.chirp.convention

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

private const val KMP_ANDROID_RESOURCES_PROPERTY = "android.experimental.kmp.enableAndroidResources"
private const val EXPECT_ACTUAL_CLASSES = "-Xexpect-actual-classes"
private const val OPT_IN_REQUIRES_OPT_IN = "-opt-in=kotlin.RequiresOptIn"
private const val OPT_IN_EXPERIMENTAL_TIME = "-opt-in=kotlin.time.ExperimentalTime"

internal fun Project.configureKotlinMultiplatform() {
    configureAndroidLibraryTarget()

    extensions.configure<KotlinMultiplatformExtension> {

        extensions.configure<KotlinMultiplatformAndroidLibraryExtension> {
            compileSdk = libs.findVersion(VERSION_COMPILE_SDK).get().toString().toInt()
            minSdk = libs.findVersion(VERSION_MIN_SDK).get().toString().toInt()
            namespace = pathToPackageName()
            experimentalProperties[KMP_ANDROID_RESOURCES_PROPERTY] = true
        }

        listOf(
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = this@configureKotlinMultiplatform.pathToFrameworkName()
            }
        }

        compilerOptions {
            freeCompilerArgs.add(EXPECT_ACTUAL_CLASSES)
            freeCompilerArgs.add(OPT_IN_REQUIRES_OPT_IN)
            freeCompilerArgs.add(OPT_IN_EXPERIMENTAL_TIME)
        }
    }
}