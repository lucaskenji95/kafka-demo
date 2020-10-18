package com.kafka.input.dto

import java.math.BigDecimal
import java.time.LocalDate

data class DollarInputDto (
        val buy: BigDecimal,
        val sell: BigDecimal,
        val dollarDate: LocalDate
)