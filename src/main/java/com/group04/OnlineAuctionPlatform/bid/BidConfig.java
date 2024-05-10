package com.group04.OnlineAuctionPlatform.bid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class BidConfig {

    @Bean
    CommandLineRunner BidcommandLineRunner(BidRepository repository){
        return args -> {
//            BidManager bid1 =  new BidManager(
//                    1L,
//                    1L,
//                    1000.00,
//                    LocalDateTime.now()
//            );
//            BidManager bid2 =  new BidManager(
//                    2L,
//                    2L,
//                    5000.00,
//                    LocalDateTime.now()
//            );
//            repository.saveAll(List.of(bid1,bid2  ));
        };

    }

}
