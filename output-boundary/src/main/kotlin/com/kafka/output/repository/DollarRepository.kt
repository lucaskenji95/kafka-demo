package com.kafka.output.repository

import com.kafka.output.dto.DollarOutputDto

interface DollarRepository {
    fun saveDollar(dollarOutputDto: DollarOutputDto)
}