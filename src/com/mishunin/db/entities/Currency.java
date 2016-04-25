package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.db.entities.annotations.EditableColumn;

/**
 * Created by Andrey on 18.04.2016.
 */
public class Currency extends BaseEntity {

    @Column("CURRENCY_ID")
    @EditableColumn(sortOrder = 0)
    private String currencyId;

    @Column("NAME")
    @EditableColumn(sortOrder = 1)
    private String name;

    @Column("DESCRIPTION")
    @EditableColumn(sortOrder = 2)
    private String description;

    @Column("EXCHANGE_RATE")
    @EditableColumn(sortOrder = 3)
    private Double exchangeRate;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
