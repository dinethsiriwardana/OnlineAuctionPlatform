package com.group04.OnlineAuctionPlatform.instance.bid;

import com.group04.OnlineAuctionPlatform.bid.BidService;

import java.util.Map;

public class BidInstance {
    private static BidInstance instance;

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

    public Map getHighestBidPrices() {
        return highestBidPrices;
    }

    public void setHighestBidPrices(BidService bidService) {

        this.highestBidPrices = bidService.getHighestBidPrices();
    }
}
