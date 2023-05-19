package com.mvctest.pojo;

import org.springframework.lang.Nullable;

public class UserEntity {
    @Nullable
    private Integer id;
    private String username;
    private String hashpassword;
    private String salt;

    public UserEntity(@Nullable Integer id, String username, String hashpassword, String salt) {
        this.id = id;
        this.username = username;
        this.hashpassword = hashpassword;
        this.salt = salt;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashpassword() {
        return hashpassword;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hashpassword='" + hashpassword + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
