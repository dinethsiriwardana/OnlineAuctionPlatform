package com.group04.OnlineAuctionPlatform.Factory;

import com.group04.OnlineAuctionPlatform.auth.UserData;
import com.group04.OnlineAuctionPlatform.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginUserFactory implements UserFactory {
    private final UserService userService;

    @Autowired
    public LoginUserFactory(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Map<String, String> createUser(UserData userData) {
        return userService.loginUser(userData.getEmail(), userData.getPassword());
    }


}
