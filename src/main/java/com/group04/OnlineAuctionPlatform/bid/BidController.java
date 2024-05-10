package com.group04.OnlineAuctionPlatform.bid;


import com.group04.OnlineAuctionPlatform.auth.UserService;
import com.group04.OnlineAuctionPlatform.utl.DataEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(path = "apis/v1/bid")
public class BidController {
    private final BidService bidService;
    private final UserService userService;


    @Autowired
    public BidController(BidService bidService, UserService userService){
        this.bidService = bidService;
        this.userService = userService;
    }

    @GetMapping()
    public List<BidManager> getBids(){
        return bidService.getBids();
    }

    @PostMapping()
    public void addBid(@RequestBody Map<String,String> bidManager){
        System.out.println(bidManager.toString());
        DataEncryption dataEncryption = new DataEncryption();


        BidManager bid = new BidManager(
                Long.valueOf(bidManager.get("itemId")),
                userService.getUser(Long.valueOf( dataEncryption.decryptPassword(bidManager.get("userId")))),
                Double.parseDouble(bidManager.get("bidPrice")),
                LocalDateTime.parse(bidManager.get("bidTime"))
        );


        bidService.addBid(bid);
    }

    @GetMapping(path ="{item_id}")
    public List<Map<String, Object>> getBid(@PathVariable("item_id") Long item_id){
        return bidService.getBidWithUserId(item_id);
    }
}
