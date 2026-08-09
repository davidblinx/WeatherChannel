plugins {
    `kotlin-dsl`
    alias(libs.plugins.android.lint) apply false
}

group = libs.versions.app.version.appId

val supportsAndroidLintPlugin = GradleVersion.current() >= GradleVersion.version("9.3.1")

if (supportsAndroidLintPlugin) {
    apply(plugin = libs.plugins.android.lint.get().pluginId)
} else {
    logger.warn(
        "Skipping ${libs.plugins.android.lint.get().pluginId} for build-logic: " +
            "requires Gradle >= 9.3.1, current is ${GradleVersion.current()}."
    )
}

java {
    toolchain {
        languageVersion.set(libs.versions.app.build.kotlinJVMTarget.map(JavaLanguageVersion::of))
    }
}

dependencies {
    compileOnly(libs.gradlePlugin.android)
    compileOnly(libs.gradlePlugin.android.tools.common)
    compileOnly(libs.gradlePlugin.kotlin)
    compileOnly(libs.gradlePlugin.compose.compiler)
    compileOnly(libs.gradlePlugin.ksp)
    if (supportsAndroidLintPlugin) {
        add("lintChecks", libs.androidx.lint.gradle)
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationConventionPlugin") {
            id = libs.plugins.convention.app.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationComposeConventionPlugin") {
            id = libs.plugins.convention.compose.app.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("hiltConventionPlugin") {
            id = libs.plugins.convention.hilt.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }

        register("kotlinSerializationConventionPlugin") {
            id = libs.plugins.convention.kotlin.serialization.get().pluginId
            implementationClass = "KotlinSerializationConventionPlugin"
        }

        register("androidLibraryConventionPlugin") {
            id = libs.plugins.convention.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryComposeConventionPlugin") {
            id = libs.plugins.convention.compose.library.get().pluginId
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}
