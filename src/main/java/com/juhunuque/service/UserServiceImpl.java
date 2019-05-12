package com.juhunuque.service;

import com.juhunuque.dao.UserDao;
import com.juhunuque.entity.SpecialisationCategory;
import com.juhunuque.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.findAllByOrderByIdAsc();
    }

    public User getById(final Long id) {
        return userDao.findUserById(id);
    }

    public User addNew(final String name, final String specialisation) {
        SpecialisationCategory specialisationCategory = SpecialisationCategory.valueOf(specialisation.toUpperCase());
        User user = new User(name, specialisationCategory);
        userDao.save(user);
        return user;
    }

    public User deleteById(final Long id) {
        User user = userDao.findUserById(id);
        userDao.delete(user);
        return user;
    }
}
