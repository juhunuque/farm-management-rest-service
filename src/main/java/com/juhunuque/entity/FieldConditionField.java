package com.juhunuque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="field_condition_field")
public class FieldConditionField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "field_condition_id")
    private Long fieldConditionId;

    public Long getId() {
        return id;
    }

    public FieldConditionField() {}

    public FieldConditionField(final Long fieldId, final Long fieldConditionId) {
        this.fieldId = fieldId;
        this.fieldConditionId = fieldConditionId;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getFieldConditionId() {
        return fieldConditionId;
    }

    public void setFieldConditionId(Long fieldConditionId) {
        this.fieldConditionId = fieldConditionId;
    }
}
