package com.juhunuque.entity;

public enum SpecialisationCategory {
    SPECIALISATION1("Specialisation1"),
    SPECIALISATION2("Specialisation2"),
    SPECIALISATION3("Specialisation3");

    private String name;

    SpecialisationCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
