package me.deadybbb.ybbbbasicmodule

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException

open class BasicConfigHandler (
    val plugin: JavaPlugin,
    val configFileName: String
) {
    var configFile: File = File(plugin.dataFolder, configFileName)
    var config: YamlConfiguration? = null

    fun reloadConfig(): Boolean {
        if (!configFile.exists()) {
            try {
                plugin.dataFolder.mkdirs()
                configFile.createNewFile()
                plugin.logger.info("Created new $configFileName")
            } catch (e: IOException) {
                plugin.logger.warning("Failed to create $configFileName: $e")
                return false
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile)
        return true
    }

    fun saveConfig(): Boolean {
        try {
            config?.save(configFile)
            plugin.logger.info("Successfully saved to $configFileName")
            return true
        } catch (e: IOException) {
            plugin.logger.warning("Failed to save $configFileName: $e")
            return false
        }
    }
}