package com.kafka.usecase.impl

import com.kafka.input.dto.DollarInputDto
import com.kafka.output.dto.DollarOutputDto
import com.kafka.output.repository.DollarRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DollarUseCaseImplTest {

    private val dollarRepository = mock<DollarRepository>()

    private val dollarUseCaseImpl = DollarUseCaseImpl(dollarRepository)

    @Test
    fun `should call repository to save dollar`() {
        val localDate = LocalDate.of(2020, 10, 1)
        val date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())

        val dollarInput = DollarInputDto(BigDecimal.TEN, BigDecimal.ZERO, localDate)
        val dollarOutput = DollarOutputDto(BigDecimal.TEN, BigDecimal.ZERO, date)
        dollarUseCaseImpl.execute(dollarInput)

        verify(dollarRepository).saveDollar(dollarOutput)
    }
}