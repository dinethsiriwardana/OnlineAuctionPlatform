package com.group04.OnlineAuctionPlatform;


import com.group04.OnlineAuctionPlatform.bid.BidController;
import com.group04.OnlineAuctionPlatform.bid.BidRepository;
import com.group04.OnlineAuctionPlatform.bid.BidService;
import com.group04.OnlineAuctionPlatform.bid.HighestBidManager;
import com.group04.OnlineAuctionPlatform.instance.bid.BidInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OnlineAuctionPlatformApplication {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		ApplicationContext context =  SpringApplication.run(OnlineAuctionPlatformApplication.class, args);

		BidInstance bidInstance = BidInstance.getInstance();
		System.out.println("BidInstance: " + bidInstance.getHighestBidPrices());
	}



}
