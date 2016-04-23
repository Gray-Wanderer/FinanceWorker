package com.mishunin.db.entities;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
public class DataOperation extends SafeEntity {

    private Date dateTs;
    private Double operationValue;
    private String description;
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
