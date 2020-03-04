package com.dao;

import com.model.User;

public interface UserDao {
    User findByUsername(String username);

    void save(User user);

    User getOne(Long userId);
}
