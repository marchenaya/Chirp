import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec
import com.codingfeline.buildkonfig.gradle.BuildKonfigExtension
import com.marchenaya.chirp.convention.pathToPackageName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class BuildKonfigConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(BUILDKONFIG_PLUGIN_ID)
            }

            extensions.configure<BuildKonfigExtension> {
                packageName.set(target.pathToPackageName())
                defaultConfigs {
                    val apiKey = gradleLocalProperties(rootDir, rootProject.providers)
                        .getProperty(API_KEY)
                        ?: throw IllegalStateException(
                            "Missing $API_KEY property in local.properties"
                        )
                    buildConfigField(FieldSpec.Type.STRING, API_KEY, apiKey)
                    val baseUrl = gradleLocalProperties(rootDir, rootProject.providers)
                        .getProperty(BASE_URL)
                        ?: throw IllegalStateException(
                            "Missing $BASE_URL property in local.properties"
                        )
                    buildConfigField(FieldSpec.Type.STRING, BASE_URL, baseUrl)
                }
            }
        }
    }

    private companion object {
        const val BUILDKONFIG_PLUGIN_ID = "com.codingfeline.buildkonfig"
        const val API_KEY = "API_KEY"
        const val BASE_URL = "BASE_URL"
    }
}