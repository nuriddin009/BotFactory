package uz.nuriddin.botfactory.father.handler

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.objects.CallbackQuery
import org.telegram.telegrambots.meta.bots.AbsSender

interface CallBackHandler {
    fun handle(callbackQuery: CallbackQuery, sender: AbsSender)
}


@Component
class CallBackHandlerImpl : CallBackHandler {
    override fun handle(callbackQuery: CallbackQuery, sender: AbsSender) {
        TODO("Not yet implemented")
    }
}