package com.academy.service;

import com.academy.model.User;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> userList;

    public AuthService() {
        userList = new ArrayList<User>();

        User bro = new User("Ivan", "Ivan1234");
        User test = new User("Test", "Test1234");
        userList.add(bro);
        userList.add(test);
    }

    public boolean authenticate(String username, String password) {
        if(username.isEmpty() || password.isEmpty()) {
            return false;
        }

        for (User user : userList) {
            if (username.equals("Ivan") && password.equals("Ivan1234")) {
                return true;
            }
        }
        return false;
    }
}
