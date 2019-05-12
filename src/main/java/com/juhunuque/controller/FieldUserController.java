package com.juhunuque.controller;

import com.juhunuque.entity.FieldUser;
import com.juhunuque.service.FieldUserServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/fieldUser/v1")
public class FieldUserController {

    @Autowired
    private FieldUserServiceImpl fieldUserService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public FieldUser addNew(@RequestBody JSONObject jsonObject) {
        Long fieldId = new Long((Integer) jsonObject.get("fieldId"));
        Long userId = new Long((Integer) jsonObject.get("userId"));
        return fieldUserService.addNew(fieldId, userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public FieldUser deleteById(@PathVariable @NotNull Long id) {
        return fieldUserService.deleteById(id);
    }
}
