package uz.nuriddin.botfactory.father

import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update
import uz.nuriddin.botfactory.config.TelegramProperties
import uz.nuriddin.botfactory.father.handler.CallBackHandler
import uz.nuriddin.botfactory.father.handler.MessageHandler
import uz.nuriddin.botfactory.service.MainBotService

@Slf4j
@Component
class MainBot(
    private val botProperties: TelegramProperties,
    private val messageHandler: MessageHandler,
    private val callBackHandler: CallBackHandler,
    botOptions: DefaultBotOptions,
) : TelegramLongPollingBot(botOptions, botProperties.token) {

    override fun onUpdateReceived(update: Update) {
        when {
            update.hasMessage() -> messageHandler.handle(update.message, this)
            update.hasCallbackQuery() -> callBackHandler.handle(update.callbackQuery, this)
        }
    }

    override fun getBotUsername(): String = botProperties.username
}