package com.vansisto.jdbc;

import com.vansisto.jdbc.dao.User;
import com.vansisto.jdbc.services.UserService;
import com.vansisto.jdbc.services.impl.UserServiceImpl;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        userService.persistUser(new User(2, "Charly"));
        userService.updateUser(new User(2, "Delta"));

        userService.printAllUsers();
    }
}
