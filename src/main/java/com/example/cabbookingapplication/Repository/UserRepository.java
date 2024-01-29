package com.example.cabbookingapplication.Repository;

import com.example.cabbookingapplication.Model.Driver;
import com.example.cabbookingapplication.Model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = Collections.synchronizedList(new ArrayList<>());
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public List<User> getUsers() {
        return users;
    }
}
