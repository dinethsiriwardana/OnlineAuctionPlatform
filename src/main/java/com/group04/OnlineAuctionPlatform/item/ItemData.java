package com.group04.OnlineAuctionPlatform.item;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class ItemData {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private double start_price;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;



    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    private Long add_by;

    public ItemData() {
    }

    public ItemData(Long id, String name, String description, double start_price, LocalDateTime createdAt, LocalDateTime expiredAt, Long add_by) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_price = start_price;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.add_by = add_by;
    }


    public ItemData(String name, String description, double start_price, String expiredAt, Long add_by) {
        // Example of parsing the date string with a custom format including fractional seconds
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime dateTime = LocalDateTime.parse("2024-05-05T10:52:47.271194", formatter);


        this.name = name;
        this.description = description;
        this.start_price = start_price;
        this.createdAt = LocalDateTime.now();

        this.expiredAt = dateTime;
        this.add_by = add_by;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStart_price() {
        return start_price;
    }

    public void setStart_price(double start_price) {
        this.start_price = start_price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Long getAdd_by() {
        return add_by;
    }

    public void setAdd_by(Long add_by) {
        this.add_by = add_by;
    }
}
