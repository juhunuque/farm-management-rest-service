package com.juhunuque.service;

import com.juhunuque.dao.FieldUserDao;
import com.juhunuque.entity.FieldUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FieldUserServiceImpl implements FieldUserService{

    @Autowired
    private FieldUserDao fieldUserDao;

    public FieldUser addNew(final Long fieldId, final Long userId) {
        FieldUser fieldUser = new FieldUser(fieldId, userId);
        fieldUserDao.save(fieldUser);
        return fieldUser;
    }

    public FieldUser deleteById(final Long id) {
        FieldUser fieldUser = fieldUserDao.findFieldUserById(id);
        fieldUserDao.delete(fieldUser);
        return fieldUser;
    }
}
