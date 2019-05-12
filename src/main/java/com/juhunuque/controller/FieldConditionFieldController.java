package com.juhunuque.controller;

import com.juhunuque.entity.FieldConditionField;
import com.juhunuque.service.FieldConditionFieldServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/fieldConditionField/v1")
public class FieldConditionFieldController {

    @Autowired
    private FieldConditionFieldServiceImpl fieldConditionFieldServiceImpl;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public FieldConditionField addNew(@RequestBody JSONObject jsonObject) {
        Long fieldId = new Long((Integer) jsonObject.get("fieldId"));
        Long fieldConditionId = new Long((Integer) jsonObject.get("fieldConditionId"));
        return fieldConditionFieldServiceImpl.addNew(fieldId, fieldConditionId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public FieldConditionField deleteById(@PathVariable @NotNull Long id) {
        return fieldConditionFieldServiceImpl.deleteById(id);
    }
}
