import com.marchenaya.chirp.convention.ANDROID_KOTLIN_MULTIPLATFORM_LIBRARY_PLUGIN_ID
import com.marchenaya.chirp.convention.ANDROID_MAIN_IMPLEMENTATION
import com.marchenaya.chirp.convention.COMPOSE_COMPILER_PLUGIN_ID
import com.marchenaya.chirp.convention.COMPOSE_PLUGIN_ID
import com.marchenaya.chirp.convention.KOTLIN_MULTIPLATFORM_PLUGIN_ID
import com.marchenaya.chirp.convention.KOTLIN_SERIALIZATION_PLUGIN_ID
import com.marchenaya.chirp.convention.LIBRARY_COMPOSE_UI_TOOLING
import com.marchenaya.chirp.convention.configureAndroidLibraryTarget
import com.marchenaya.chirp.convention.configureIosTargets
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(ANDROID_KOTLIN_MULTIPLATFORM_LIBRARY_PLUGIN_ID)
                apply(KOTLIN_MULTIPLATFORM_PLUGIN_ID)
                apply(COMPOSE_PLUGIN_ID)
                apply(COMPOSE_COMPILER_PLUGIN_ID)
                apply(KOTLIN_SERIALIZATION_PLUGIN_ID)
            }

            configureAndroidLibraryTarget()
            configureIosTargets()

            dependencies {
                ANDROID_MAIN_IMPLEMENTATION(libs.findLibrary(LIBRARY_COMPOSE_UI_TOOLING).get())
            }
        }
    }

}