package com.group04.OnlineAuctionPlatform.item;


import com.group04.OnlineAuctionPlatform.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public List<ItemData> getItems() {
        try {
            return itemRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get items");
        }
    }

    public Map getItem(Long itemId) {
        try {
            ItemData item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item not found"));
            if (item != null) {
               //find user by id
                String username = userRepository.findById(item.getAdd_by()).orElseThrow(() -> new IllegalStateException("User not found")).getName();

                return Map.of("id",item.getId(),"name", item.getName(), "description", item.getDescription(), "start_price", item.getStart_price(), "expiredAt", item.getExpiredAt().toString(), "add_by", username);
            }
//            return itemRepository.findById(itemId).orElseThrow(() -> new IllegalStateException("Item not found"));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get item "+ e.toString());
        }

        return null;
    }

    public Map<String,String> addItem(ItemData itemData) {
        try {

            itemRepository.save(itemData);
            ItemData savedItem = itemRepository.save(itemData);

            return Map.of("message", "Item added successfully", "itemId", savedItem.getId().toString());
        } catch (Exception e) {
            throw new IllegalStateException("Failed to add item "+ e.toString());
        }
    }
}
