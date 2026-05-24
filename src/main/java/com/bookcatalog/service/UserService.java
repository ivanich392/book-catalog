package com.bookcatalog.service;

import com.bookcatalog.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User create(User user);

    void delete(Long id);
}