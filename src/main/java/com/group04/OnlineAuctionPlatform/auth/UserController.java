package com.group04.OnlineAuctionPlatform.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "apis/v1/userdata")
public class UserController {

    private final UserService userService;


    @Autowired
    public  UserController(UserService userService){
        this.userService = userService;
    }

    //user register , login , logout codes
    @GetMapping()
    public void loginUser(){

        userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody UserData userData){
        userService.registerUser(userData);
    }






}
