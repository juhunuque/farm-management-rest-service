package com.juhunuque.service;

import com.juhunuque.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(final Long id);
    User addNew(final String name, final String specialisation);
    User deleteById(final Long id);
}
