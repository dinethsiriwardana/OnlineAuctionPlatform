package com.group04.OnlineAuctionPlatform.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BidService {

    private final BidRepository bidRepository;

    @Autowired
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }
    public List<BidManager> getBids() {
        return bidRepository.findAll();
    }

    public void addBid(BidManager bidManager) {
        bidRepository.save(bidManager);
    }

    public List<BidManager> getBid(Long item_id) {
        return bidRepository.findByItemIdOrderByBidTimeDesc(item_id);
    }
}
