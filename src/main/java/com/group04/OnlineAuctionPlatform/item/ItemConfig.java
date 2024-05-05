package com.group04.OnlineAuctionPlatform.item;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ItemConfig {


    @Bean
    CommandLineRunner ItemcommandLineRunner(ItemRepository repository){
        return args -> {
            ItemData item1 =  new ItemData(
                    "Car",
                    "This is a car",
                    1000.00,

                    LocalDateTime.now().toString(),
                    1L

            );
            ItemData item2 =  new ItemData(
                    "Bus",
                    "This is a Bus",
                    5000.00,

                    LocalDateTime.now().toString(),

                    1L

            );
//            repository.saveAll(List.of(item1,item2  ));
        };

}}
