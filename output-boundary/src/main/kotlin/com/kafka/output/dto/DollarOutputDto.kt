package com.kafka.output.dto

import java.math.BigDecimal
import java.util.*

data class DollarOutputDto (
        val buy: BigDecimal,
        val sell: BigDecimal,
        val dollarDate: Date
)