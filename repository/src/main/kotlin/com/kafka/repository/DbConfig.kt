package com.kafka.repository

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(basePackages = ["com.kafka.repository"])
class DbConfig {

//    @Bean(name = ["DollarDomain"])
//    @ConfigurationProperties("spring.datasource")
//    fun dataSource(): HikariDataSource? {
//        return DataSourceBuilder.create()
//                .type(HikariDataSource::class.java)
//                .driverClassName("org.postgresql.Driver")
//                .build()
//    }
//
//    @Bean(name = ["DollarConfigFactory"])
//    fun dollarConfigFactory(builder: EntityManagerFactoryBuilder, @Qualifier("DollarDomain") dataSource: DataSource)
//    : LocalContainerEntityManagerFactoryBean{
//        return builder.dataSource(dataSource).packages("com.kafka.repository.domain").build()
//    }
}