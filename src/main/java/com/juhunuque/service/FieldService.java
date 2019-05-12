package com.juhunuque.service;

import com.juhunuque.entity.Field;
import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.util.List;

public interface FieldService {

    List<Field> getAll();
    Field getById(final Long id);
    Field addNew(final String name, final String cropType, final BigDecimal latitude, final BigDecimal longitude);
    Field deleteById(final Long id);
    List<Field> find(final JSONObject jsonObject);
}
