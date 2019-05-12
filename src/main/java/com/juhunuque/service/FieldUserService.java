package com.juhunuque.service;

import com.juhunuque.entity.FieldUser;

public interface FieldUserService {

    FieldUser addNew(final Long fieldId, final Long userId);
    FieldUser deleteById(final Long id);
}
