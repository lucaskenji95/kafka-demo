package com.kafka.usecase.impl

import com.kafka.input.usecase.DollarUseCase
import com.kafka.input.dto.DollarInputDto
import com.kafka.output.dto.DollarOutputDto
import com.kafka.output.repository.DollarRepository
import org.springframework.stereotype.Service
import java.time.ZoneId
import java.util.*

@Service
class DollarUseCaseImpl(
        val dollarRepository: DollarRepository
) : DollarUseCase {
    override fun execute(dollarInputDto: DollarInputDto) {
        val dollarDate = Date.from(dollarInputDto.dollarDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        val dollarOutputDto = DollarOutputDto(
                dollarInputDto.buy,
                dollarInputDto.sell,
                dollarDate
        )
        dollarRepository.saveDollar(dollarOutputDto)
    }
}