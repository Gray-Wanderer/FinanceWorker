package com.mishunin.ui;

import com.mishunin.db.DbWorker;
import com.mishunin.db.entities.BaseEntity;
import com.mishunin.utils.MetaUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Andrey on 25.04.2016.
 */
public class DBObjectControllerImpl<T extends BaseEntity> implements DBObjectController {

    private Class<T> entityType;
    private List<T> entityList;
    private List<String> columnNames;

    public DBObjectControllerImpl(Class<T> entityType) {
        this.entityType = entityType;
        this.columnNames = MetaUtils.getAllGettersParamNames(entityType);
        try {
            update();
        } catch (SQLException e) {
            throw new RuntimeException("Can't load entities from database", e);
        }
    }

    @Override
    public Object getParameter(int rowIndex, int columnIndex) {
        return entityList.get(rowIndex).getValue(columnNames.get(columnIndex));
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);  //todo add localization
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return MetaUtils.findGetterReturnType(entityType, columnNames.get(columnIndex));
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return entityList.size();
    }

    @Override
    public T getDataObject(int rowIndex) {
        return entityList.get(rowIndex);
    }

    @Override
    public void update() throws SQLException {
        this.entityList = DbWorker.getInstance().findEntities(entityType);
    }
}
