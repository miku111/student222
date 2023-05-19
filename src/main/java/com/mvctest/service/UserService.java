package com.mvctest.service;


import com.mvctest.mapper.userMapper;
import com.mvctest.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    @Autowired
    private userMapper um;

    public boolean register(String username,String password) throws NoSuchAlgorithmException {
        System.out.println(username+"    "+password);
        //System.out.println(id);
        if(um.selectByName(username)!=null){
            return false;
        }

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String saltString = Base64.getEncoder().encodeToString(salt);

        // Hash the password with the salt
        String hashedPassword = hashPassword(password, salt);
        UserEntity userEntity=new UserEntity(null,username,hashedPassword,saltString);
        return um.insertUser(userEntity);

    }

    private String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-384");
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean login(String username,String password) throws NoSuchAlgorithmException {
    UserEntity userEntity=um.selectByName(username);
        String hashedEnteredPassword = hashPassword(password, Base64.getDecoder().decode(userEntity.getSalt()));
        return userEntity.getHashpassword().equals(hashedEnteredPassword);

    }
}
