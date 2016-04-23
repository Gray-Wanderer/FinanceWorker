package com.mishunin.db.entities;

/**
 * Created by Andrey on 18.04.2016.
 */
public class Property extends BaseEntity {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
