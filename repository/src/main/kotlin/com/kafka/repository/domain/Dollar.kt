package com.kafka.repository.domain

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Dollar")
data class Dollar (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long? = null,

        @Column(name = "dollar_date")
        private val dollarDate: Date? = null,

        private val buy: BigDecimal? = null,

        private val sell: BigDecimal? = null
)