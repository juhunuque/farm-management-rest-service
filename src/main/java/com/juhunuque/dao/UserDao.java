package com.juhunuque.dao;

import com.juhunuque.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    List<User> findAllByOrderByIdAsc();
    User findUserByName(final String name);
    User findUserById(final Long id);
}
