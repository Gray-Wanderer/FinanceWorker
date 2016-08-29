package com.mishunin.db.entities;

import com.mishunin.db.entities.annotations.Column;
import com.mishunin.db.entities.annotations.EditableColumn;
import com.mishunin.db.entities.annotations.Entity;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
@Entity(tableName = "DATA_CONVERSION")
public class DataConversion extends SafeEntity {

    @Column("DATE_TS")
    @EditableColumn(sortOrder = 0)
    private Date dateTs;

    @Column("DESCRIPTION")
    @EditableColumn(sortOrder = 1)
    private String description;

    @Column("CONVERSION_VALUE")
    @EditableColumn(sortOrder = 2)
    private Double conversionValue;

    @Column("CURRENCY_FROM_ID")
    @EditableColumn(sortOrder = 3)
    private Currency fromCurrency;

    @Column("CURRENCY_TO_ID")
    @EditableColumn(sortOrder = 4)
    private Currency toCurrency;

    @Column("EXCHANGE_RATE")
    @EditableColumn(sortOrder = 5)
    private Double exchangeRate;

    public Date getDateTs() {
        return dateTs;
    }

    public void setDateTs(Date dateTs) {
        this.dateTs = dateTs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(Double conversionValue) {
        this.conversionValue = conversionValue;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
