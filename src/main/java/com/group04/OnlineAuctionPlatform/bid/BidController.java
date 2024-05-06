package com.group04.OnlineAuctionPlatform.bid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(path = "apis/v1/bid")
public class BidController {
    private final BidService bidService;


    @Autowired
    public BidController(BidService bidService){
        this.bidService = bidService;
    }

    @GetMapping()
    public List<BidManager> getBids(){
        return bidService.getBids();
    }

    @PostMapping()
    public void addBid(@RequestBody BidManager bidManager){
         bidService.addBid(bidManager);
    }

    @GetMapping(path ="{item_id}")
    public List<BidManager> getBid(@PathVariable("item_id") Long item_id){
        return bidService.getBid(item_id);
    }
}
