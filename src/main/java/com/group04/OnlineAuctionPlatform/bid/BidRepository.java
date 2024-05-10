package com.group04.OnlineAuctionPlatform.bid;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<BidManager,Long>{
    List<BidManager> findByItemIdOrderByBidTimeDesc(Long item_id);

}
