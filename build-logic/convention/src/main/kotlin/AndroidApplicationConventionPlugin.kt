import com.android.build.api.dsl.ApplicationExtension
import com.marchenaya.chirp.convention.configureKotlinAndroid
import com.marchenaya.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(ANDROID_APPLICATION_PLUGIN_ID)
            }
            extensions.configure<ApplicationExtension> {
                namespace = NAMESPACE

                defaultConfig {
                    applicationId = libs.findVersion(VERSION_APPLICATION_ID).get().toString()
                    targetSdk = libs.findVersion(VERSION_TARGET_SDK).get().toString().toInt()
                    versionCode = libs.findVersion(VERSION_CODE).get().toString().toInt()
                    versionName = libs.findVersion(VERSION_NAME).get().toString()
                }
                packaging {
                    resources {
                        excludes += PACKAGING_EXCLUDES
                    }
                }
                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile(PROGUARD_OPTIMIZE_FILE),
                            PROGUARD_RULES_FILE
                        )
                    }
                }
                buildFeatures {
                    compose = true
                }

                configureKotlinAndroid(this)
            }
        }
    }

    private companion object {
        const val ANDROID_APPLICATION_PLUGIN_ID = "com.android.application"
        const val NAMESPACE = "com.marchenaya.chirp"
        const val VERSION_APPLICATION_ID = "projectApplicationId"
        const val VERSION_TARGET_SDK = "projectTargetSdkVersion"
        const val VERSION_CODE = "projectVersionCode"
        const val VERSION_NAME = "projectVersionName"
        const val PACKAGING_EXCLUDES = "/META-INF/{AL2.0,LGPL2.1}"
        const val PROGUARD_OPTIMIZE_FILE = "proguard-android-optimize.txt"
        const val PROGUARD_RULES_FILE = "proguard-rules.pro"
    }

}