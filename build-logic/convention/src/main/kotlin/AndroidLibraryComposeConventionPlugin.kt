import com.android.build.api.dsl.LibraryExtension
import com.david.weatherchannel.configureAndroidCompose
import com.david.weatherchannel.getPluginId
import com.david.weatherchannel.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = libs.getPluginId("kotlin-compose"))

            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}
