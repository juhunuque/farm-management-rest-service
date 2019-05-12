package com.juhunuque.entity;

public enum CropTypeCategory {
    CROPTYPECATEGORY1("CropTypeCategory1"),
    CROPTYPECATEGORY2("CropTypeCategory2"),
    CROPTYPECATEGORY3("CropTypeCategory3");

    private String name;

    CropTypeCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
