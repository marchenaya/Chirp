import com.marchenaya.chirp.convention.COMMON_MAIN_IMPLEMENTATION
import com.marchenaya.chirp.convention.COMPOSE_COMPILER_PLUGIN_ID
import com.marchenaya.chirp.convention.COMPOSE_PLUGIN_ID
import com.marchenaya.chirp.convention.LIBRARY_COMPOSE_UI_TOOLING
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(KMP_LIBRARY_CONVENTION_PLUGIN_ID)
                apply(COMPOSE_COMPILER_PLUGIN_ID)
                apply(COMPOSE_PLUGIN_ID)
            }

            dependencies {
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_UI).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_FOUNDATION).get())
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_MATERIAL3).get())
                COMMON_MAIN_IMPLEMENTATION(
                    libs.findLibrary(LIBRARY_COMPOSE_MATERIAL_ICONS_CORE).get()
                )
                COMMON_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_UI_TOOLING).get())
            }
        }
    }

    private companion object {
        const val KMP_LIBRARY_CONVENTION_PLUGIN_ID = "com.marchenaya.convention.kmp.library"
        const val LIBRARY_COMPOSE_UI = "jetbrains-compose-ui"
        const val LIBRARY_COMPOSE_FOUNDATION = "jetbrains-compose-foundation"
        const val LIBRARY_COMPOSE_MATERIAL3 = "jetbrains-compose-material3"
        const val LIBRARY_COMPOSE_MATERIAL_ICONS_CORE = "jetbrains-compose-material-icons-core"
    }

}