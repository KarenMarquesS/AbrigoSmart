package org.example.abrigosmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories
@EntityScan
@SpringBootApplication
@EnableCaching
class AbrigoSmartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbrigoSmartApplication.class, args);
    }

}
