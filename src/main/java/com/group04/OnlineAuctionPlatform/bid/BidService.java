package com.group04.OnlineAuctionPlatform.bid;

import com.group04.OnlineAuctionPlatform.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BidService {

    private final BidRepository bidRepository;

    private final UserRepository userRepository;


    @Autowired
    public BidService(BidRepository bidRepository, UserRepository userRepository) {
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
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
    public List<Map<String, Object>> getBidWithUserId(Long itemId) {
        List<BidManager> bids = bidRepository.findByItemIdOrderByBidTimeDesc(itemId);
        return bids.stream().map(bid -> {
            Map<String, Object> map = Map.of(
                    "id", bid.getId(),
                    "itemId", bid.getItemId(),
                    "userId", bid.getUser().getName(),
                    "bidPrice", bid.getBidPrice(),
                    "bidTime", bid.getBidTime()
            );
            return map;
        }).collect(Collectors.toList());
    }
}
