package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.db.entities.annotations.EditableColumn;
import com.mishunin.db.entities.annotations.Entity;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
@Entity(tableName = "DATA_OPERATION")
public class DataOperation extends SafeEntity {

    @Column("DATE_TS")
    @EditableColumn(sortOrder = 0)
    private Date dateTs;

    @Column("OPERATION_VALUE")
    @EditableColumn(sortOrder = 1)
    private Double operationValue;

    @Column("DESCRIPTION")
    @EditableColumn(sortOrder = 2)
    private String description;

    @Column("DATA_CATEGORY_ID")
    @EditableColumn(sortOrder = 3)
    private DataCategory dataCategory;

    public Date getDateTs() {
        return dateTs;
    }

    public void setDateTs(Date dateTs) {
        this.dateTs = dateTs;
    }

    public Double getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(Double operationValue) {
        this.operationValue = operationValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataCategory getDataCategory() {
        return dataCategory;
    }

    public void setDataCategory(DataCategory dataCategory) {
        this.dataCategory = dataCategory;
    }
}
