package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.db.entities.annotations.EditableColumn;

/**
 * Created by Andrey on 18.04.2016.
 */
public class DataCategory extends SafeEntity {

    @Column("NAME")
    @EditableColumn(sortOrder = 0)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
