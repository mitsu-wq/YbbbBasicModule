package me.deadybbb.ybbbbasicmodule

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.command.CommandSender
import java.util.regex.Pattern

class LegacyTextHandler {
    companion object {
        private val LEGACY_PATTERN: Pattern = Pattern.compile("&[0-9a-fk-or]")

        @JvmStatic
        fun parseText(text: String): Component {
            val msg = if (LEGACY_PATTERN.matcher(text).find()) {
                LegacyComponentSerializer.legacyAmpersand().deserialize(text)
            } else {
                MiniMessage.miniMessage().deserialize(text)
            }
            return msg
        }

        @JvmStatic
        fun sendFormattedMessage(sender: CommandSender, text: String) {
            sender.sendMessage(text)
        }
    }
}