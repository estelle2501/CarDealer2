package com.wordpress.zapiskiprogramistki.CarDealer2.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages ={"com.wordpress.zapiskiprogramistki.CarDealer2.car"})
@EnableJpaRepositories(basePackages = {"com.wordpress.zapiskiprogramistki.CarDealer2.car"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
