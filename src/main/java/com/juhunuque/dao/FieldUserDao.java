package com.juhunuque.dao;

import com.juhunuque.entity.FieldUser;
import org.springframework.data.repository.CrudRepository;

public interface FieldUserDao extends CrudRepository<FieldUser, Long> {

    FieldUser findFieldUserById(final Long id);
}
