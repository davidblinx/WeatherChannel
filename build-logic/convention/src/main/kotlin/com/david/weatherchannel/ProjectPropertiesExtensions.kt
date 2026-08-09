package com.david.weatherchannel

import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

fun Project.getPropertiesIfExist(fileName: String, message: String): Properties? {
    val file = layout.projectDirectory.file(fileName).asFile
    if (!file.exists()) {
        println(message)
        return null
    }
    return Properties().apply {
        load(FileInputStream(file))
    }
}
