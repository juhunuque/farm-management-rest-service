package com.juhunuque.dao;

import com.juhunuque.entity.FieldConditionField;
import org.springframework.data.repository.CrudRepository;

public interface FieldConditionFieldDao extends CrudRepository<FieldConditionField, Long> {

    FieldConditionField findFieldConditionFieldById(final Long id);
}
