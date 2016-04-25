package com.mishunin.ui;

import com.mishunin.db.entities.BaseEntity;

import java.sql.SQLException;

/**
 * Created by Andrey on 24.04.2016.
 */
public interface DBObjectController<T extends BaseEntity> {

    /**
     * Получить объект в ячейке таблицы
     * @param rowIndex индекс строки
     * @param columnIndex индекс столбца
     * @return
     */
    Object getParameter(int rowIndex, int columnIndex);

    /**
     * Получить название столбца
     * @param columnIndex индекс столбца
     * @return
     */
    String getColumnName(int columnIndex);

    /**
     * Получить тип объектов столбца
     * @param columnIndex индекс столбца
     * @return
     */
    Class getColumnClass(int columnIndex);

    /**
     * Получить количество столбцов
     * @return количество столбцов
     */
    int getColumnCount();

    /**
     * Получить количество строк
     * @return количество строк
     */
    int getRowCount();

    /**
     * Получить объект отвечающий за строку
     * @param rowIndex
     * @return
     */
    T getDataObject(int rowIndex);

    /**
     * Обновить данные
     * @throws SQLException
     */
    void update() throws SQLException;

}