package com.kafka.repository

import com.kafka.repository.domain.Dollar
import org.springframework.data.repository.CrudRepository

interface DollarCrudRepository : CrudRepository<Dollar, Long>