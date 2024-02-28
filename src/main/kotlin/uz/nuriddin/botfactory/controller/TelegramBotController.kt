package uz.nuriddin.botfactory.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.telegram.telegrambots.meta.api.objects.Update
import uz.nuriddin.botfactory.service.TelegramBotService


@RestController
@RequestMapping("api/v1/telegram-bot")
class TelegramBotController(
    private val telegramBotService: TelegramBotService
) {

    @PostMapping("{type}/{token}")
    fun onUpdateReceived(@RequestBody update: Update, @PathVariable type: String, @PathVariable token: String) {
        telegramBotService.checkBot(update,type,token)
    }

}