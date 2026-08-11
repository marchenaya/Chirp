import com.marchenaya.chirp.convention.ANDROID_KOTLIN_MULTIPLATFORM_LIBRARY_PLUGIN_ID
import com.marchenaya.chirp.convention.COMMON_MAIN_IMPLEMENTATION
import com.marchenaya.chirp.convention.COMMON_TEST_IMPLEMENTATION
import com.marchenaya.chirp.convention.KOTLIN_MULTIPLATFORM_PLUGIN_ID
import com.marchenaya.chirp.convention.KOTLIN_SERIALIZATION_PLUGIN_ID
import com.marchenaya.chirp.convention.configureKotlinMultiplatform
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(ANDROID_KOTLIN_MULTIPLATFORM_LIBRARY_PLUGIN_ID)
                apply(KOTLIN_MULTIPLATFORM_PLUGIN_ID)
                apply(KOTLIN_SERIALIZATION_PLUGIN_ID)
            }

            configureKotlinMultiplatform()

            dependencies {
                COMMON_MAIN_IMPLEMENTATION(
                    libs.findLibrary(LIBRARY_KOTLINX_SERIALIZATION_JSON).get()
                )
                COMMON_TEST_IMPLEMENTATION(libs.findLibrary(LIBRARY_KOTLIN_TEST).get())
            }
        }
    }

    private companion object {
        const val LIBRARY_KOTLINX_SERIALIZATION_JSON = "kotlinx-serialization-json"
        const val LIBRARY_KOTLIN_TEST = "kotlin-test"
    }

}