package com.juhunuque.service;

import com.juhunuque.dao.FieldConditionDao;
import com.juhunuque.entity.FieldCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldConditionServiceImpl implements FieldConditionService {

    @Autowired
    private FieldConditionDao fieldConditionDao;

    public List<FieldCondition> getAll() {
        return fieldConditionDao.findAllByOrderByIdAsc();
    }

    public FieldCondition getById(final Long id) {
        return fieldConditionDao.findFieldConditionById(id);
    }

    public FieldCondition addNew(final Integer temperature, final String cloudinessInformation, final Integer vegetationInformation) {
        FieldCondition fieldCondition = new FieldCondition(temperature, cloudinessInformation, vegetationInformation);
        fieldConditionDao.save(fieldCondition);
        return fieldCondition;
    }

    public FieldCondition deleteById(final Long id) {
        FieldCondition fieldCondition = fieldConditionDao.findFieldConditionById(id);
        fieldConditionDao.delete(fieldCondition);
        return fieldCondition;
    }


}
