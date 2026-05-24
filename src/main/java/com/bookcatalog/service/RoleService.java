package com.bookcatalog.service;

import com.bookcatalog.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();

    Role getById(Long id);

    Role create(Role role);

    void delete(Long id);
}