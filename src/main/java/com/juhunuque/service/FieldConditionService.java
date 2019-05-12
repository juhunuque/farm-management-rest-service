package com.juhunuque.service;

import com.juhunuque.entity.FieldCondition;

import java.util.List;

public interface FieldConditionService {

    List<FieldCondition> getAll();
    FieldCondition getById(final Long id);
    FieldCondition addNew(final Integer temperature, final String cloudinessInformation, final Integer vegetationInformation);
    FieldCondition deleteById(final Long id);
}
