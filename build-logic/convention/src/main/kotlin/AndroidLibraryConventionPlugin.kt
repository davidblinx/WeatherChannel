import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.david.weatherchannel.addLibrariesConfig
import com.david.weatherchannel.commonVersioning
import com.david.weatherchannel.configureBuildFeatures
import com.david.weatherchannel.configureJavaCompatibilityCompileOptions
import com.david.weatherchannel.configureKotlin
import com.david.weatherchannel.configureLibraryAndTestNameSpace
import com.david.weatherchannel.disableUnnecessaryAndroidTests
import com.david.weatherchannel.getLibrary
import com.david.weatherchannel.getPluginId
import com.david.weatherchannel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.getPluginId("android-library"))

            configureLibraryAndTestNameSpace()

            extensions.configure<LibraryExtension> {
                configureKotlin<KotlinAndroidProjectExtension>()
                commonVersioning(this)
                configureBuildFeatures()
                addLibrariesConfig()
                configureJavaCompatibilityCompileOptions(this)
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                disableUnnecessaryAndroidTests(target)
            }

            dependencies {
                "androidTestImplementation"(libs.getLibrary("kotlin-test"))
                "testImplementation"(libs.getLibrary("kotlin-test"))
                "testImplementation"(libs.getLibrary("unit-test-junit"))
                "implementation"(libs.getLibrary("androidx-tracing"))
            }
        }
    }
}
