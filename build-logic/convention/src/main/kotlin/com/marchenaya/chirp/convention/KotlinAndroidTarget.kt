package com.marchenaya.chirp.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidLibraryTarget() {
    dependencies {
        CORE_LIBRARY_DESUGARING(libs.findLibrary(LIBRARY_DESUGAR_JDK_LIBS).get())
    }
}