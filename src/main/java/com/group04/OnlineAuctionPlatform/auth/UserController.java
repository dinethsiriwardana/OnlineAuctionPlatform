package com.group04.OnlineAuctionPlatform.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

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
    public List<UserData> loginUser(){
        return userService.getUsers();
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody UserData userData){

        return userService.loginUser(userData.getEmail(),userData.getPassword());
    }

    @PostMapping
    public void registerUser(@RequestBody UserData userData){
        userService.registerUser(userData);
    }










}
