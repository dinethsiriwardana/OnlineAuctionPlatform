package com.group04.OnlineAuctionPlatform.bid;

import com.group04.OnlineAuctionPlatform.auth.UserData;
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

    @ManyToOne(fetch = FetchType.LAZY) // Assuming many bids belong to one user
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserData user;

    private double bidPrice;
    private LocalDateTime bidTime;

    public BidManager() {
    }

    public BidManager(Long id, Long itemId, UserData user, double bidPrice, LocalDateTime bidTime) {
        this.id = id;
        this.itemId = itemId;
        this.user = user;
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

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public BidManager(Long itemId, UserData user, double bidPrice, LocalDateTime bidTime) {
        this.itemId = itemId;
        this.user = user;
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
    }



}
