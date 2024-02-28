package uz.nuriddin.botfactory.father

import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import uz.nuriddin.botfactory.config.Bot


@Component
abstract class ChildBot: TelegramLongPollingBot("") {
     abstract var botConfig: Bot


    override fun getBotUsername(): String = botConfig.username

    override fun onUpdateReceived(update: Update?) {
        val message = update!!.message

        execute(SendMessage(message.chatId.toString(), message.text))

    }

}