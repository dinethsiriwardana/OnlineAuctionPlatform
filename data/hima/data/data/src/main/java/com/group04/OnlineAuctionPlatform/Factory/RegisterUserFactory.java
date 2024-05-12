package com.group04.OnlineAuctionPlatform.Factory;


import com.group04.OnlineAuctionPlatform.auth.UserData;
import com.group04.OnlineAuctionPlatform.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RegisterUserFactory implements UserFactory {

    private final UserService userService;

    @Autowired
    public RegisterUserFactory(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Map<String, String> createUser(UserData userData) {
        return userService.registerUser(userData);
    }
}