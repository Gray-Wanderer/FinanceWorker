package com.mishunin.ui;

import com.mishunin.db.entities.BaseEntity;

import java.sql.SQLException;

/**
 * Created by Andrey on 25.04.2016.
 */
public class DBObjectControllerImpl<T extends BaseEntity> implements DBObjectController {

    private Class<T> entityType;

    public DBObjectControllerImpl(Class<T> entityType) {
        this.entityType = entityType;
    }

    @Override
    public Object getParameter(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return null;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public T getDataObject(int rowIndex) {
        return null;
    }

    @Override
    public void update() throws SQLException {

    }
}
