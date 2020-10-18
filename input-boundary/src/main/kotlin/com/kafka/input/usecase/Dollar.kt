package com.kafka.input.usecase

import com.kafka.input.dto.DollarInputDto

interface Dollar {
    fun execute(dollarInputDto: DollarInputDto)
}