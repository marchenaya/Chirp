package com.marchenaya.chirp.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

private const val VERSION_CATALOG_NAME = "libs"

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named(VERSION_CATALOG_NAME)