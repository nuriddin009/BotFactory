package uz.nuriddin.botfactory.service

import org.telegram.telegrambots.meta.api.objects.Update
import uz.nuriddin.botfactory.config.Bot


interface MainBotService {

    fun onUpdateReceived(update: Update?)

    fun bot(bot: Bot)

}