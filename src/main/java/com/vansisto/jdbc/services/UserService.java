package com.vansisto.jdbc.services;

import com.vansisto.jdbc.dao.User;

public interface UserService {
    void persistUser(User user);
    void printAllUsers();
    void updateUser(User user);
}
