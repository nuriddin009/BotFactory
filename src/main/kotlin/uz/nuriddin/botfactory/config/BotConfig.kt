package uz.nuriddin.botfactory.config

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import uz.nuriddin.botfactory.father.MainBot
import uz.nuriddin.botfactory.father.handler.CallBackHandler
import uz.nuriddin.botfactory.father.handler.MessageHandler


@Component
class BotConfig(
    private val messageHandler: MessageHandler,
    private val callBackHandler: CallBackHandler,
    private val telegramProperties: TelegramProperties,
) {

    @Bean
    fun defaultBotOptions(): DefaultBotOptions {
        val options = DefaultBotOptions()
        options.maxThreads = 10
        return options
    }



    @Bean
    fun telegramBotsApi(): TelegramBotsApi {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(
            MainBot(
            telegramProperties,
            messageHandler,
            callBackHandler,
            DefaultBotOptions())
        )
        return telegramBotsApi
    }


}