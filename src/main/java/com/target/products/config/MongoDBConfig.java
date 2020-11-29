package com.target.products.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.target.products.document.Price;
import com.target.products.document.Products;
import com.target.products.repository.ProductRepository;

@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return strings -> {
            productRepository.save(new Products("1", "Peter", new Price(2.5f, "$")));
            productRepository.save(new Products("2", "Sam", new Price(2.5f, "$")));
        };
    }

}
