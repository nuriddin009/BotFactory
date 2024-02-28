package uz.nuriddin.botfactory.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "telegram-bot", ignoreInvalidFields = false)
class TelegramProperties(
    var username: String = "",
    var token: String = "",
)