package com.group04.OnlineAuctionPlatform.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping(path = "apis/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping()
    public List<ItemData> getItems(){
        return itemService.getItems();
    }

    @GetMapping(path ="{itemId}")
    public ItemData getItem(@PathVariable("itemId") Long itemId){
        return itemService.getItem(itemId);
    }

    @PostMapping()
    public Map<String,String> addItem(@RequestBody ItemData itemData){
        return itemService.addItem(itemData);
    }
}
