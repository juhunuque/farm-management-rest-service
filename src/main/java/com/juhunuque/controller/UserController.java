package com.juhunuque.controller;

import com.juhunuque.entity.User;
import com.juhunuque.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getAll() {
        return userServiceImpl.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getById(@PathVariable @NotNull Long id) {
        return userServiceImpl.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addNew(@RequestBody JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        String specialisation = (String) jsonObject.get("specialisation");
        return userServiceImpl.addNew(name, specialisation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteById(@PathVariable @NotNull Long id) {
        return userServiceImpl.deleteById(id);
    }
}
