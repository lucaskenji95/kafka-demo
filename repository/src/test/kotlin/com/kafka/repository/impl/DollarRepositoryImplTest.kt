package com.kafka.repository.impl

import com.kafka.output.dto.DollarOutputDto
import com.kafka.repository.DollarCrudRepository
import com.kafka.repository.domain.Dollar
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

class DollarRepositoryImplTest {

    private val dollarCrudRepository = mock<DollarCrudRepository>()

    private val dollarRepositoryImpl = DollarRepositoryImpl(dollarCrudRepository)

    @Test
    fun `should save dollar on db`() {
        val expectedSavedDollar = Dollar(1L, Date(), BigDecimal.ONE, BigDecimal.ONE)
        val dollarOutputDto = DollarOutputDto(BigDecimal.ONE, BigDecimal.ONE, Date())

        whenever(dollarCrudRepository.findById(1L)).thenReturn(Optional.of(expectedSavedDollar))
        dollarRepositoryImpl.saveDollar(dollarOutputDto)

        val savedDollar = dollarCrudRepository.findById(1L).orElse(null)

        assertEquals(expectedSavedDollar, savedDollar)
    }
}