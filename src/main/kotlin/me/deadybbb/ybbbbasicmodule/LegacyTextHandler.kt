package me.deadybbb.ybbbbasicmodule

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.command.CommandSender
import java.util.regex.Pattern

open class LegacyTextHandler {
    companion object {
        private val LEGACY_PATTERN = Pattern.compile("&[0-9a-fk-or]")
        private val MINI_MESSAGE = MiniMessage.miniMessage()
        private val PLAIN_TEXT_SERIALIZER = PlainTextComponentSerializer.plainText()

        @JvmStatic
        fun parseText(text: String): Component {
            val msg = if (LEGACY_PATTERN.matcher(text).find()) {
                LegacyComponentSerializer.legacyAmpersand().deserialize(text)
            } else {
                MINI_MESSAGE.deserialize(text)
            }
            return msg
        }

        @JvmStatic
        fun sendFormattedMessage(sender: CommandSender, text: String) {
            sender.sendMessage(parseText(text))
        }

        @JvmStatic
        fun sendFormattedMessage(sender: CommandSender, text: Component) {
            sender.sendMessage(text)
        }

        @JvmStatic
        fun stripFormatting(text: String): String {
            val plainText = LEGACY_PATTERN.matcher(text).replaceAll("")
            return PLAIN_TEXT_SERIALIZER.serialize(parseText(plainText))
        }
    }
}