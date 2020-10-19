package com.kafka.repository.impl

import com.kafka.output.dto.DollarOutputDto
import com.kafka.output.repository.DollarRepository
import com.kafka.repository.DollarCrudRepository
import com.kafka.repository.domain.Dollar
import org.springframework.stereotype.Repository

@Repository
class DollarRepositoryImpl(
        val dollarCrudRepository: DollarCrudRepository
) : DollarRepository {
    override fun saveDollar(dollarOutputDto: DollarOutputDto) {
        val dollar = Dollar(
                buy = dollarOutputDto.buy,
                sell = dollarOutputDto.sell,
                dollarDate = dollarOutputDto.dollarDate
        )

        dollarCrudRepository.save(dollar)
    }
}