package com.juhunuque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp createdTimestamp;
    private Timestamp updatedTimestamp;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SpecialisationCategory specialization;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
    @JoinTable(name = "field_user",
                joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = { @JoinColumn(name = "field_id")})
    private Set<Field> fields = new HashSet<>();

    public User() {}

    public User(final String name, final SpecialisationCategory specialisationCategory) {
        this.name = name;
        this.specialization = specialisationCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public SpecialisationCategory getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecialisationCategory specialization) {
        this.specialization = specialization;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
}
