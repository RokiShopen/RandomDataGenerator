package com.random.people;

import com.random.people.generators.PersonGenerator;
import com.random.people.validator.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PersonGenerator personGenerator(){
        return new PersonGenerator();
    }

    @Bean
    public Validator validator(){
        return new Validator();
    }
}
