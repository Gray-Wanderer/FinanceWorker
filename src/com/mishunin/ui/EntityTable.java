package com.mishunin.ui;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Andrey on 24.04.2016.
 */
public class EntityTable extends AbstractTableModel {

    /** Объект данных */
    private DBObjectController dataObject = null;

    /**
     * Метод доступа
     * @param controller Объект данных
     */
    public void setDataObject(DBObjectController controller) {
        dataObject = controller;
        fireTableStructureChanged();
    }

    /**
     * Метод доступа
     * @return Объект данных
     */
    public DBObjectController getDataObject() {
        return dataObject;
    }

    /**
     * Метод доступа
     * @param lss Объект данных
     */
    public void setStudentSession(DBObjectController lss) {
        dataObject = lss;
        fireTableStructureChanged();
    }

    @Override
    public Class getColumnClass(int c) {
        return dataObject.getColumnClass(c);
    }

    @Override
    public String getColumnName(int c) {
        return dataObject.getColumnName(c);
    }

    @Override
    public int getRowCount() {
        if (dataObject != null) {
            return dataObject.getRowCount();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {

        if (dataObject != null) {
            return dataObject.getColumnCount();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return dataObject.getParameter(rowIndex, columnIndex);

    }

}
