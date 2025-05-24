package me.deadybbb.ybbbbasicmodule

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class BasicLoggerHandler(
    plugin: JavaPlugin
) {
    val logger = plugin.logger
    val name = plugin.name

    fun info(msg: String) {
        logger.info("[$name] $msg")
    }

    fun warning(msg: String) {
        logger.warning("[$name] $msg")
    }

    fun severe(msg: String) {
        logger.severe("[$name] $msg")
    }
}