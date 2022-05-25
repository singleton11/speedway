package io.github.singleton11.speedway.gradle

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

@Suppress("unused")
class SpeedwayConfigurationSettingsPlugin : Plugin<Settings> {
    override fun apply(target: Settings) {
        println("Hello settings plugin")
    }
}