package com.group04.OnlineAuctionPlatform.auth;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all users
    public List<UserData> getUsers(){
        UserData user1 =  new UserData(
                "Dineth",
                "info@dineth.me",
                "$Student@123",
                "USER"

        );


        return List.of(user1);
//        return userRepository.findAll();
    }

    public void registerUser(UserData userData) {
        Optional<UserData> userOptional = userRepository.findUserByEmail(userData.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        userRepository.save(userData);

    }
}
