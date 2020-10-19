package com.kafka.consumer

import com.google.gson.Gson
import com.kafka.consumer.dto.DollarMessage
import com.kafka.input.dto.DollarInputDto
import com.kafka.input.usecase.DollarUseCase
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Answers
import org.mockito.ArgumentMatchers.anyString
import java.math.BigDecimal
import java.time.LocalDate

class KafkaConsumerTest {

    private val dollar = mock<DollarUseCase>()
    private val gson = mock<Gson>()

    private val kafkaConsumer = KafkaConsumer(dollar, gson)

    private val dollarMessage = mock<DollarMessage>(defaultAnswer = Answers.RETURNS_DEEP_STUBS)

    @Test
    fun `should call execute method from use case`() {
        val date = LocalDate.of(2020, 10, 1)

        val dollarInputExpected = DollarInputDto(BigDecimal.TEN, BigDecimal.ZERO, date)
        whenever(dollarMessage.buy).thenReturn(BigDecimal.TEN)
        whenever(dollarMessage.sell).thenReturn(BigDecimal.ZERO)
        whenever(dollarMessage.dollarDate).thenReturn("01-10-2020")
        whenever(gson.fromJson(anyString(), eq(DollarMessage::class.java))).thenReturn(dollarMessage)

        kafkaConsumer.processDollarMessage("")
        verify(dollar).execute(dollarInputExpected)
    }

    @Test
    fun `should throw exception when there is an invalid value`() {
        whenever(dollarMessage.buy).thenReturn(BigDecimal.ONE)
        whenever(dollarMessage.sell).thenReturn(BigDecimal.ZERO)
        whenever(dollarMessage.dollarDate).thenReturn(null)
        whenever(gson.fromJson(anyString(), eq(DollarMessage::class.java))).thenReturn(dollarMessage)

        Assertions.assertThrows(NullPointerException::class.java) {kafkaConsumer.processDollarMessage("")}
    }
}