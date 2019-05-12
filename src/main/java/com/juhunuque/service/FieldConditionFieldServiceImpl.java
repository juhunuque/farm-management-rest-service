package com.juhunuque.service;

import com.juhunuque.dao.FieldConditionFieldDao;
import com.juhunuque.entity.FieldConditionField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldConditionFieldServiceImpl implements FieldConditionFieldService {

    @Autowired
    private FieldConditionFieldDao fieldConditionFieldDao;

    public FieldConditionField addNew(final Long fieldId, final Long fieldConditionId) {
        FieldConditionField fieldConditionField = new FieldConditionField(fieldId, fieldConditionId);
        fieldConditionFieldDao.save(fieldConditionField);
        return fieldConditionField;
    }

    public FieldConditionField deleteById(Long id) {
        FieldConditionField fieldConditionField = fieldConditionFieldDao.findFieldConditionFieldById(id);
        fieldConditionFieldDao.delete(fieldConditionField);
        return fieldConditionField;
    }
}
