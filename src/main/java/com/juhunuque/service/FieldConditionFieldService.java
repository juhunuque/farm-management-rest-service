package com.juhunuque.service;

import com.juhunuque.entity.FieldConditionField;

public interface FieldConditionFieldService {

    FieldConditionField addNew(final Long fieldId, final Long fieldConditionId);
    FieldConditionField deleteById(final Long id);
}
