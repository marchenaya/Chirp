import com.marchenaya.chirp.convention.ANDROID_MAIN_IMPLEMENTATION
import com.marchenaya.chirp.convention.COMMON_MAIN_IMPLEMENTATION
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(CMP_LIBRARY_CONVENTION_PLUGIN_ID)
            }

            dependencies {
                COMMON_MAIN_IMPLEMENTATION(project(PROJECT_CORE_PRESENTATION))
                COMMON_MAIN_IMPLEMENTATION(project(PROJECT_CORE_DESIGNSYSTEM))

                COMMON_MAIN_IMPLEMENTATION(platform(libs.findLibrary(LIBRARY_KOIN_BOM).get()))
                ANDROID_MAIN_IMPLEMENTATION(platform(libs.findLibrary(LIBRARY_KOIN_BOM).get()))

                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOIN_COMPOSE).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOIN_COMPOSE_VIEWMODEL).get())

                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_RUNTIME).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_VIEWMODEL).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_LIFECYCLE_VIEWMODEL).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_LIFECYCLE_COMPOSE).get())

                COMMON_MAIN_IMPLEMENTATION(
                    libs.findLibrary(LIBRARY_LIFECYCLE_VIEWMODEL_SAVEDSTATE).get()
                )
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_SAVEDSTATE).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_BUNDLE).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_NAVIGATION).get())

                ANDROID_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOIN_ANDROID).get())
                ANDROID_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOIN_ANDROIDX_COMPOSE).get())
                ANDROID_MAIN_IMPLEMENTATION(
                    libs.findLibrary(LIBRARY_KOIN_ANDROIDX_NAVIGATION).get()
                )
                ANDROID_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOIN_CORE_VIEWMODEL).get())
            }
        }
    }

    private companion object {
        const val CMP_LIBRARY_CONVENTION_PLUGIN_ID = "com.marchenaya.convention.cmp.library"

        const val PROJECT_CORE_PRESENTATION = ":core:presentation"
        const val PROJECT_CORE_DESIGNSYSTEM = ":core:designsystem"

        const val LIBRARY_KOIN_BOM = "koin-bom"
        const val LIBRARY_KOIN_COMPOSE = "koin-compose"
        const val LIBRARY_KOIN_COMPOSE_VIEWMODEL = "koin-compose-viewmodel"
        const val LIBRARY_KOIN_ANDROID = "koin-android"
        const val LIBRARY_KOIN_ANDROIDX_COMPOSE = "koin-androidx-compose"
        const val LIBRARY_KOIN_ANDROIDX_NAVIGATION = "koin-androidx-navigation"
        const val LIBRARY_KOIN_CORE_VIEWMODEL = "koin-core-viewmodel"

        const val LIBRARY_COMPOSE_RUNTIME = "jetbrains-compose-runtime"
        const val LIBRARY_COMPOSE_VIEWMODEL = "jetbrains-compose-viewmodel"
        const val LIBRARY_COMPOSE_NAVIGATION = "jetbrains-compose-navigation"
        const val LIBRARY_LIFECYCLE_VIEWMODEL = "jetbrains-lifecycle-viewmodel"
        const val LIBRARY_LIFECYCLE_COMPOSE = "jetbrains-lifecycle-compose"
        const val LIBRARY_LIFECYCLE_VIEWMODEL_SAVEDSTATE =
            "jetbrains-lifecycle-viewmodel-savedstate"
        const val LIBRARY_SAVEDSTATE = "jetbrains-savedstate"
        const val LIBRARY_BUNDLE = "jetbrains-bundle"
    }

}