package uz.nuriddin.botfactory.father.handler

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.bots.AbsSender
import uz.nuriddin.botfactory.payload.TelegramBotInfo

interface MessageHandler {
    fun handle(message: Message, sender: AbsSender);
}


@Component
class MessageHandlerImpl(
) : MessageHandler {
    override fun handle(message: Message, sender: AbsSender) {
        val telegramUser = message.from
        val chatId = telegramUser.id.toString()

        val sendMessage = SendMessage()
        sendMessage.enableHtml(true)
        sendMessage.chatId = chatId

        if (message.hasText()) {
            when (val text = message.text) {
                "/start" -> {
                    sendMessage.text = "Salom ${telegramUser.firstName} ${telegramUser.lastName}"
                    sender.execute(sendMessage)
                }

                else -> {
                    val apiUrl = "https://api.telegram.org/bot$text/getMe"
                    val restTemplate = RestTemplate()
                    val responseEntity: ResponseEntity<TelegramBotInfo> =
                        restTemplate.getForEntity(apiUrl, TelegramBotInfo::class.java)

                    if (responseEntity.statusCode.is2xxSuccessful) {
                        val telegramBotInfo: TelegramBotInfo =
                            responseEntity.body ?: throw IllegalStateException("Response body is null")
                        println(telegramBotInfo)

                        val forEntity = RestTemplate().getForEntity(
                            "https://api.telegram.org/bot$text/setwebhook?url=https://1632-89-249-62-103.ngrok-free.app/api/v1/telegram-bot",
                            Any::class.java
                        )
                        println(forEntity.body)

                    } else {
                        println("Error occurred")
                    }
                }
            }

        }


    }
}