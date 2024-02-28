package uz.nuriddin.botfactory.payload

import com.fasterxml.jackson.annotation.JsonProperty

data class Result(
    val id: Long,
    @JsonProperty("is_bot")
    val isBot: Boolean,
    @JsonProperty("first_name")
    val firstName: String,
    val username: String,
    @JsonProperty("can_join_groups")
    val canJoinGroups: Boolean,
    @JsonProperty("can_read_all_group_messages")
    val canReadAllGroupMessages: Boolean,
    @JsonProperty("supports_inline_queries")
    val supportsInlineQueries: Boolean
)

data class TelegramBotInfo(
    @JsonProperty("ok")
    val isOk: Boolean,
    val result: Result
)