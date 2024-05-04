package com.group04.OnlineAuctionPlatform;

import com.group04.OnlineAuctionPlatform.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class OnlineAuctionPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAuctionPlatformApplication.class, args);
	}



}
