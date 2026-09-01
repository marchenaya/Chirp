import androidx.room.gradle.RoomExtension
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class RoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(KSP_PLUGIN_ID)
                apply(ROOM_PLUGIN_ID)
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/$SCHEMAS_PATH")
            }

            dependencies {
                COMMON_MAIN_API(libs.findLibrary(LIBRARY_ANDROIDX_ROOM_RUNTIME).get())
                COMMON_MAIN_API(libs.findLibrary(LIBRARY_SQLITE_BUNDLED).get())
                KSP_ANDROID(libs.findLibrary(LIBRARY_ANDROIDX_ROOM_COMPILER).get())
                KSP_IOS_SIMULATOR_ARM64(libs.findLibrary(LIBRARY_ANDROIDX_ROOM_COMPILER).get())
                KSP_IOS_ARM64(libs.findLibrary(LIBRARY_ANDROIDX_ROOM_COMPILER).get())
                KSP_IOS_X64(libs.findLibrary(LIBRARY_ANDROIDX_ROOM_COMPILER).get())
            }
        }
    }

    private companion object {
        const val KSP_PLUGIN_ID = "com.google.devtools.ksp"
        const val ROOM_PLUGIN_ID = "androidx.room"
        const val SCHEMAS_PATH = "schemas"
        const val COMMON_MAIN_API = "commonMainApi"
        const val KSP_ANDROID = "kspAndroid"
        const val KSP_IOS_SIMULATOR_ARM64 = "kspIosSimulatorArm64"
        const val KSP_IOS_ARM64 = "kspIosArm64"
        const val KSP_IOS_X64 = "kspIosX64"
        const val LIBRARY_ANDROIDX_ROOM_RUNTIME = "androidx-room-runtime"
        const val LIBRARY_SQLITE_BUNDLED = "sqlite-bundled"
        const val LIBRARY_ANDROIDX_ROOM_COMPILER = "androidx-room-compiler"
    }

}