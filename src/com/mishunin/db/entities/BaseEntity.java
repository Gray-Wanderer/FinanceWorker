package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.utils.MetaUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Andrey on 18.04.2016.
 */
public abstract class BaseEntity {

    @Column("ID")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setValue(String paramName, Object value) {
        Method setter = MetaUtils.findSetter(this.getClass(), paramName);
        if (setter == null)
            throw new RuntimeException(String.format("Setter for method %s not found", paramName));  //todo create new Exception type
        try {
            setter.invoke(this, value);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();  //todo add Logger
        }
    }

    public Object getValue(String paramName) {
        Method getter = MetaUtils.findGetter(this.getClass(), paramName);
        if (getter == null)
            throw new RuntimeException(String.format("Getter for method %s not found", paramName));  //todo create new Exception type, add localisation
        try {
            return getter.invoke(this);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();  //todo add Logger
        }
        return null;
    }

    public String getTableName() {
        return MetaUtils.getTableName(this.getClass());
    }
}
