import com.android.build.api.dsl.ApplicationExtension
import com.david.weatherchannel.commonVersioning
import com.david.weatherchannel.configureAppPluginPackageAndNameSpace
import com.david.weatherchannel.configureBuildFeatures
import com.david.weatherchannel.configureJavaCompatibilityCompileOptions
import com.david.weatherchannel.configureKotlin
import com.david.weatherchannel.getPluginId
import com.david.weatherchannel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.getPluginId("android-application"))
            apply(plugin = libs.getPluginId("convention-compose-app"))
            apply(plugin = libs.getPluginId("convention-hilt"))

            extensions.configure<ApplicationExtension> {
                configureKotlin<KotlinAndroidProjectExtension>()
                commonVersioning(this)
                configureAppPluginPackageAndNameSpace(this)
                configureBuildFeatures()
                configureJavaCompatibilityCompileOptions(this)
            }
        }
    }
}
