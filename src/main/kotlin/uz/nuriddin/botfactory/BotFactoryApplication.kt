package uz.nuriddin.botfactory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class BotFactoryApplication

fun main(args: Array<String>) {
    runApplication<BotFactoryApplication>(*args)
}

//@Bean
//fun restTemplate(): RestTemplate {
//    return RestTemplate()
//}
