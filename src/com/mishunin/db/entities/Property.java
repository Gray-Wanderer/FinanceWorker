package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.db.entities.annotations.EditableColumn;

/**
 * Created by Andrey on 18.04.2016.
 */
public class Property extends BaseEntity {

    @Column("NAME")
    @EditableColumn(sortOrder = 0)
    private String name;

    @Column("VALUE")
    @EditableColumn(sortOrder = 2)
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
