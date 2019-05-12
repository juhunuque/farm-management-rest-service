package com.juhunuque.dao;

import com.juhunuque.entity.FieldCondition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FieldConditionDao extends CrudRepository<FieldCondition, Long> {

    List<FieldCondition> findAllByOrderByIdAsc();
    FieldCondition findFieldConditionById(final Long id);
}
