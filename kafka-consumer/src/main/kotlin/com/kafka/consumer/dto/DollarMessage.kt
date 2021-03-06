package com.kafka.consumer.dto

import java.math.BigDecimal
import java.time.LocalDate

data class DollarMessage (
        val buy: BigDecimal,
        val sell: BigDecimal,
        val dollarDate: String,
        val high: BigDecimal,
        val low: BigDecimal
)

