package com.group04.OnlineAuctionPlatform.bid;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table

public class BidManager {

    @Id
    @SequenceGenerator(
            name = "bid_sequence",
            sequenceName = "bid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bid_sequence"
    )

    private Long id;

    private Long itemId;
    private Long userId;
    private double bidPrice;
    private LocalDateTime bidTime;


    public BidManager() {
    }

    public BidManager(Long id, Long itemId, Long userId, double bidPrice, LocalDateTime bidTime) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
    }

    public BidManager(Long itemId, Long userId, double bidPrice, LocalDateTime bidTime) {
        this.itemId = itemId;
        this.userId = userId;
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long item_id) {
        this.itemId = item_id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bid_price) {
        this.bidPrice = bid_price;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bid_time) {
        this.bidTime = bid_time;
    }
}
