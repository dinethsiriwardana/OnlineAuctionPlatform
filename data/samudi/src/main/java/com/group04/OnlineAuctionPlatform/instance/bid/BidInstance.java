package com.group04.OnlineAuctionPlatform.instance.bid;

import com.group04.OnlineAuctionPlatform.bid.BidService;

import java.util.Map;

public class BidInstance {
    private static BidInstance instance;
    private BidService bidService;

    private Map highestBidPrices;

    private BidInstance() {
    }

    public static BidInstance getInstance() {
        if (instance == null) {
            System.out.println("Creating new BidInstance");
            instance = new BidInstance();

        }

        return instance;
    }

    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    public Map getInstHighestBidPrices() {
        System.out.println("Getting highest bid prices");

        return highestBidPrices;
    }

    public void setInstHighestBidPrices() {
        System.out.println("Setting highest bid prices");
        this.highestBidPrices = bidService.getHighestBidPrices();
    }
}
