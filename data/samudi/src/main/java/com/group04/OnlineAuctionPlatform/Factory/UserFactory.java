package com.group04.OnlineAuctionPlatform.Factory;

import com.group04.OnlineAuctionPlatform.auth.UserData;

import java.util.Map;

public interface UserFactory {
    Map<String, String> createUser(UserData userData);

}
