package com.juhunuque.controller;

import com.juhunuque.entity.FieldCondition;
import com.juhunuque.service.FieldConditionServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/fieldCondition/v1")
public class FieldConditionController {

    @Autowired
    private FieldConditionServiceImpl fieldConditionServiceImpl;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<FieldCondition> getAll() {
        return fieldConditionServiceImpl.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public FieldCondition getById(@PathVariable @NotNull Long id) {
        return fieldConditionServiceImpl.getById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public FieldCondition addNew(@RequestBody JSONObject jsonObject) {
        Integer temperature = (Integer) jsonObject.get("temperature");
        String cloudinessInformation = (String) jsonObject.get("cloudinessInformation");
        Integer vegetationInformation = (Integer) jsonObject.get("vegetationInformation");
        return fieldConditionServiceImpl.addNew(temperature, cloudinessInformation, vegetationInformation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public FieldCondition deleteById(@PathVariable @NotNull Long id) {
        return fieldConditionServiceImpl.deleteById(id);
    }
}
