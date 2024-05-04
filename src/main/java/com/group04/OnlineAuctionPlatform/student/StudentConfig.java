package com.group04.OnlineAuctionPlatform.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.APRIL;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student dineth =  new Student(
                    "Dineth",
                    "info@gmail.com",
                    LocalDate.of(
                            2000,
                            APRIL,
                            5
                    )

            );
            Student Siriwardhana =  new Student(
                    "Siriwardhana",
                    "info@Siriwardhana.com",
                    LocalDate.of(
                            2001,
                            APRIL,
                            5
                    )
            );
            repository.saveAll(List.of(dineth,Siriwardhana));
        };
    }
}
