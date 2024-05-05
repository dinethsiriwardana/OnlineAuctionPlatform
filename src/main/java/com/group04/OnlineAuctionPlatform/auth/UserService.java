package com.group04.OnlineAuctionPlatform.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all users

    public List<UserData> getUsers(){
        return userRepository.findAll();
    }


    public Map<String, String> loginUser(String email, String password) {
        Optional<UserData> userOptional = userRepository.findUserByEmail(email);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("User not found");
        }
        UserData user = userOptional.get();
        if(!user.getPassword().equals(encryptPassword(password))){
            throw new IllegalStateException("Password is incorrect");
        }
        Map<String, String> response = new HashMap<>();
        response.put("token", encryptPassword(user.getPassword()));
        return response;
    }

    public void registerUser(UserData userData) {
        Optional<UserData> userOptional = userRepository.findUserByEmail(userData.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        userData.setPassword(encryptPassword(userData.getPassword()));

        userRepository.save(userData);

    }
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
