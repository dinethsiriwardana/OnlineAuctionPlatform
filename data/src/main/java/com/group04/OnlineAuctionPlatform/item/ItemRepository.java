package com.group04.OnlineAuctionPlatform.item;

import com.group04.OnlineAuctionPlatform.auth.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemRepository extends JpaRepository<ItemData,Long> {

}
