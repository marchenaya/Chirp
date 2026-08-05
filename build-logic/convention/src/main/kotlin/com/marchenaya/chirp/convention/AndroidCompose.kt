package com.marchenaya.chirp.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private const val COMPOSE_BOM = "androidx-compose-bom"
private const val COMPOSE_UI_TOOLING_PREVIEW = "jetbrains-compose-ui-tooling-preview"

internal fun Project.configureAndroidCompose(
    applicationExtension: ApplicationExtension
) {
    with(applicationExtension) {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary(COMPOSE_BOM).get()
            IMPLEMENTATION(platform(bom))
            TEST_IMPLEMENTATION(platform(bom))
            DEBUG_IMPLEMENTATION(libs.findLibrary(COMPOSE_UI_TOOLING_PREVIEW).get())
            DEBUG_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_UI_TOOLING).get())
        }
    }
}
