package com.group04.OnlineAuctionPlatform.auth;


import com.group04.OnlineAuctionPlatform.Factory.LoginUserFactory;
import com.group04.OnlineAuctionPlatform.Factory.RegisterUserFactory;
import com.group04.OnlineAuctionPlatform.Factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "apis/v1/userdata")
public class UserController {

    private final UserFactory loginUserFactory;
    private final UserFactory registerUserFactory;

    private final UserService userService;

    @Autowired
    public UserController(LoginUserFactory loginUserFactory, RegisterUserFactory registerUserFactory, UserService userService) {
        this.loginUserFactory = loginUserFactory;
        this.registerUserFactory = registerUserFactory;
        this.userService = userService;
    }

    //user register , login , logout codes
    @GetMapping()
    public List<UserData> loginUser(){
        return userService.getUsers();
    }



    @GetMapping(path = "{id}")
    public UserData getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }



    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody UserData userData){

        return loginUserFactory.createUser(userData);
    }

    @PostMapping
    public Map<String, String> registerUser(@RequestBody UserData userData){
      return  registerUserFactory.createUser(userData);
    }










}
