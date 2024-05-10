package com.group04.OnlineAuctionPlatform.item;


import com.group04.OnlineAuctionPlatform.utl.DataEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Map getItem(@PathVariable("itemId") Long itemId){

        return itemService.getItem(itemId);

    }

    @PostMapping()
    public Map<String, String> addItem(@RequestBody Map<String,String> itemData){
        DataEncryption dataEncryption = new DataEncryption();



        ItemData item = new ItemData(
                itemData.get("name"),
                itemData.get("description"),
                Double.parseDouble(itemData.get("start_price")),
                LocalDateTime.parse(itemData.get("expiredAt")),
                Long.valueOf( dataEncryption.decryptPassword(itemData.get("add_by")))
        );
        System.out.println(item.toString());
        return itemService.addItem(item);
//        return itemService.addItem(itemData);
    }
}
