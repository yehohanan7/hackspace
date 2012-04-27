package com.hackspace.services;


import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, String> users = new HashMap<String, String>();

    public UserService(Map<String, String> users) {
        this.users.putAll(users);
    }

    public String findUser(String userId) {
        return users.get(userId);
    }
}
