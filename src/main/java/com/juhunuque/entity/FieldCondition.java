package com.juhunuque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="field_condition")
public class FieldCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    @Column(name = "updated_timestamp")
    private Timestamp updatedTimestamp;

    private Integer temperature;

    @Column(name = "cloudiness_information")
    private String cloudinessInformation;

    @Column(name = "vegetation_information")
    private Integer vegetationInformation;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinTable(name = "field_condition_field",
            joinColumns = {@JoinColumn(name = "field_condition_id")},
            inverseJoinColumns = { @JoinColumn(name = "field_id")})
    private Set<Field> fields = new HashSet<>();

    public FieldCondition() {}

    public FieldCondition(final Integer temperature, final String cloudinessInformation, final Integer vegetationInformation) {
        this.temperature = temperature;
        this.cloudinessInformation = cloudinessInformation;
        this.vegetationInformation = vegetationInformation;
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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getCloudinessInformation() {
        return cloudinessInformation;
    }

    public void setCloudinessInformation(String cloudinessInformation) {
        this.cloudinessInformation = cloudinessInformation;
    }

    public Integer getVegetationInformation() {
        return vegetationInformation;
    }

    public void setVegetationInformation(Integer vegetationInformation) {
        this.vegetationInformation = vegetationInformation;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
}
