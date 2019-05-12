package com.juhunuque.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timestamp")
    private Timestamp updatedTimestamp;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CropTypeCategory cropType;

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}, mappedBy = "fields")
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL}, mappedBy = "fields")
    private Set<FieldCondition> fieldConditions = new HashSet<>();

    public Field() {}

    public Field(final String name, final CropTypeCategory cropType, final BigDecimal latitude, final BigDecimal longitude) {
        this.name = name;
        this.cropType = cropType;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CropTypeCategory getCropType() {
        return cropType;
    }

    public void setCropType(CropTypeCategory cropType) {
        this.cropType = cropType;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<FieldCondition> getFieldConditions() {
        return fieldConditions;
    }

    public void setFieldConditions(Set<FieldCondition> fieldConditions) {
        this.fieldConditions = fieldConditions;
    }
}
