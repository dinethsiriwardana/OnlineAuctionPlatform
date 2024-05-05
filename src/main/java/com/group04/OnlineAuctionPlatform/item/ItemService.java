package com.group04.OnlineAuctionPlatform.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemData> getItems() {
        try {
            System.out.println(itemRepository.findAll().toString());
            return itemRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get items");
        }
    }

    public ItemData getItem(Long itemId) {
        try {
            return itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item not found"));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get item "+ e.toString());
        }
    }

    public void addItem(ItemData itemData) {
        try {
            itemRepository.save(itemData);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to add item "+ e.toString());
        }
    }
}
