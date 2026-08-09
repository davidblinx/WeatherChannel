import com.android.build.gradle.api.AndroidBasePlugin
import com.david.weatherchannel.getLibrary
import com.david.weatherchannel.getPluginId
import com.david.weatherchannel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.getPluginId("ksp"))

            dependencies {
                "ksp"(libs.getLibrary("hilt-compiler"))
                "ksp"(libs.getLibrary("kotlin-metadata"))
                "testImplementation"(libs.getLibrary("hilt-android-testing"))
                "androidTestImplementation"(libs.getLibrary("hilt-android-testing"))
                "kspTest"(libs.getLibrary("hilt-compiler"))
            }

            pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                dependencies {
                    "implementation"(libs.getLibrary("hilt-core"))
                }
            }

            pluginManager.withPlugin("com.android.base") {
                apply(plugin = libs.getPluginId("hilt"))
                dependencies {
                    "implementation"(libs.getLibrary("hilt-android"))
                }
            }
        }
    }
}
