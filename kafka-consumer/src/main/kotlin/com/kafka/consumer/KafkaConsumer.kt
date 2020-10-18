package com.kafka.consumer

import com.google.gson.Gson
import com.kafka.consumer.dto.DollarMessage
import com.kafka.input.usecase.Dollar
import com.kafka.input.dto.DollarInputDto
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component

@Component
@EnableBinding(Sink::class)
class KafkaConsumer(
        val dollar: Dollar,
        val gson: Gson
) {

    @StreamListener(Sink.INPUT)
    fun processDollarMessage(message: String) {
        val dollarMessage = gson.fromJson(message, DollarMessage::class.java)

        val dollarInputDto = DollarInputDto(
            dollarMessage.buy,
            dollarMessage.sell,
            dollarMessage.dollarDate
        )

        dollar.execute(dollarInputDto)

    }
}