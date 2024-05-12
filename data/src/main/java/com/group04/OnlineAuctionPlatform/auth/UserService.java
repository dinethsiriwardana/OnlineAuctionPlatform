package com.group04.OnlineAuctionPlatform.auth;


import com.group04.OnlineAuctionPlatform.utl.DataEncryption;
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

    DataEncryption dataEncryption = new DataEncryption();

    public Map<String, String> loginUser(String email, String password) {

        Optional<UserData> userOptional = userRepository.findUserByEmail(email);

        if(userOptional.isEmpty()){
            throw new IllegalStateException("User not found");
        }
        UserData user = userOptional.get();
        if(!user.getPassword().equals(dataEncryption.encryptPassword(password))){
            throw new IllegalStateException("Password is incorrect");
        }
        Map<String, String> response = new HashMap<>();
        response.put("token", dataEncryption.encryptPassword(user.getId().toString()));
        return response;
    }

    public  Map<String, String> registerUser(UserData userData) {
        System.out.println(userData.getEmail()+" "+userData.getPassword()+" "+userData.getName());
        String password = userData.getPassword();
        Optional<UserData> userOptional = userRepository.findUserByEmail(userData.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        userData.setPassword(dataEncryption.encryptPassword(userData.getPassword()));
        try {
            userRepository.save(userData);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set User Data");
        }

        return loginUser(userData.getEmail(), password);
    }


    public UserData getUser(Long userId){
        try {
            UserData user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not found"));
            if (user != null) {
                return user;
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to get user "+ e.toString());
        }

        return null;
    }


}
