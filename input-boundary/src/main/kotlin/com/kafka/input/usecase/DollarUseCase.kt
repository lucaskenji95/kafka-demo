package com.kafka.input.usecase

import com.kafka.input.dto.DollarInputDto

interface DollarUseCase {
    fun execute(dollarInputDto: DollarInputDto)
}