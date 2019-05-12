package com.juhunuque.controller;

import com.juhunuque.entity.Field;
import com.juhunuque.service.FieldServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/field/v1")
public class FieldController {

    @Autowired
    private FieldServiceImpl fieldServiceImpl;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Field> getAll() {
        return fieldServiceImpl.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Field getById(@PathVariable @NotNull Long id) {
        return fieldServiceImpl.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Field addNew(@RequestBody JSONObject jsonObject) {
        String name = (String) jsonObject.get("name");
        String cropType = (String) jsonObject.get("cropType");
        BigDecimal latitude = new BigDecimal((String) jsonObject.get("latitude"));
        BigDecimal longitude = new BigDecimal((String) jsonObject.get("longitude"));
        return fieldServiceImpl.addNew(name, cropType, latitude, longitude);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Field deleteById(@PathVariable @NotNull Long id) {
        return fieldServiceImpl.deleteById(id);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<Field> find(@RequestBody JSONObject jsonObject) {
        return fieldServiceImpl.find(jsonObject);
    }
}
