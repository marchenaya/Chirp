import com.android.build.api.dsl.ApplicationExtension
import com.marchenaya.chirp.convention.COMPOSE_COMPILER_PLUGIN_ID
import com.marchenaya.chirp.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(ANDROID_APPLICATION_CONVENTION_PLUGIN_ID)
                apply(COMPOSE_COMPILER_PLUGIN_ID)
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
        }
    }

    private companion object {
        const val ANDROID_APPLICATION_CONVENTION_PLUGIN_ID =
            "com.marchenaya.convention.android.application"
    }

}