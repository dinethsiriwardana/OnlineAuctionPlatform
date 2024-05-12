package com.group04.OnlineAuctionPlatform.auth;

import com.group04.OnlineAuctionPlatform.student.Student;
import com.group04.OnlineAuctionPlatform.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.APRIL;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner UsercommandLineRunner(UserRepository repository){
        return args -> {
            UserData user1 =  new UserData(
                    "Dineth",
                    "info@dineth.me",
                   "2HvjSCN3Rym+mNvwdThKRwlze5xtdCKJyLfWsy9A31A=",
                    "USER"

            );
            UserData user2 =  new UserData(
                    "Dineth",
                    "my@dineth.me",
                    "$Student@123",
                    "USER"

            );
//            repository.saveAll(List.of(user1,user2));
        };
    }
}
