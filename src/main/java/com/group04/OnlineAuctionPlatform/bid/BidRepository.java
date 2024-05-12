package com.group04.OnlineAuctionPlatform.bid;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BidRepository extends JpaRepository<BidManager,Long>{
    List<BidManager> findByItemIdOrderByBidTimeDesc(Long item_id);

    @Query(value = "SELECT * FROM ( SELECT id, item_id , bid_price, ROW_NUMBER() OVER (PARTITION BY item_id ORDER BY bid_price DESC) AS rn FROM bid_manager ) AS t WHERE rn = 1",nativeQuery = true)
    List<Map> findMaxBidPriceForEachItem();


}
