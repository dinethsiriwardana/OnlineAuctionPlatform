package com.group04.OnlineAuctionPlatform.bid;

public class HighestBidManager {

    private Long id;
    private Long item_id;
    private Double bid_price;

    public HighestBidManager(Long id, Long item_id, Double bid_price) {
        this.id = id;
        this.item_id = item_id;
        this.bid_price = bid_price;
    }

    public HighestBidManager() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Double getBid_price() {
        return bid_price;
    }

    public void setBid_price(Double bid_price) {
        this.bid_price = bid_price;
    }

}
