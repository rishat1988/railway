package com.service;

import com.model.User;

public interface UserService {
    void create(User user);

    User findByUsername(String username);

    String encodePassword(String password);

    Boolean checkPassword(User user, String password);

    User getUserById(Long userId);
}