package com.group04.OnlineAuctionPlatform.bid;

import com.group04.OnlineAuctionPlatform.instance.bid.BidInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class BidService {

    private final BidRepository bidRepository;

    BidInstance bidInstance = BidInstance.getInstance();




    @Autowired
    public BidService(BidRepository bidRepository ) {
        this.bidRepository = bidRepository;

    }
    public List<BidManager> getBids() {
        return bidRepository.findAll();
    }

    public void addBid(BidManager bidManager) throws RemoteException, AlreadyBoundException {
        bidRepository.save(bidManager);
        bidInstance.setInstHighestBidPrices();

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


    public Map getHighestBidPrices() {
        List<Map> highestBidPrices = bidRepository.findMaxBidPriceForEachItem();
        Map<Object, Map<String, Object>> resultMap = new HashMap<>();
        highestBidPrices.forEach(map -> {
            Object itemId = map.get("item_id");
            Map<String, Object> innerMap = new HashMap<>();
            innerMap.put("id", map.get("id"));
            innerMap.put("bidPrice", map.get("bid_price"));
            resultMap.put(itemId, innerMap);
        });





        return resultMap;
    }
}
