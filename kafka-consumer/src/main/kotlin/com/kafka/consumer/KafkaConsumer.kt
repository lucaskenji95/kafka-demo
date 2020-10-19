package com.kafka.consumer

import com.google.gson.Gson
import com.kafka.consumer.dto.DollarMessage
import com.kafka.input.dto.DollarInputDto
import com.kafka.input.usecase.DollarUseCase
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
@EnableBinding(Sink::class)
class KafkaConsumer(
        val dollarUseCase: DollarUseCase,
        val gson: Gson
) {

    @StreamListener(Sink.INPUT)
    fun processDollarMessage(message: String) {
        val dollarMessage = gson.fromJson(message, DollarMessage::class.java)

        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val dollarDate : LocalDate = LocalDate.parse(dollarMessage.dollarDate, dateTimeFormatter)

        val dollarInputDto = DollarInputDto(
            dollarMessage.buy,
            dollarMessage.sell,
            dollarDate
        )

        dollarUseCase.execute(dollarInputDto)

    }
}