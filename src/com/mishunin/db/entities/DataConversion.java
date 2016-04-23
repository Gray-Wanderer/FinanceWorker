package com.mishunin.db.entities;

import java.util.Date;

/**
 * Created by Andrey on 18.04.2016.
 */
public class DataConversion extends SafeEntity {

    private Date dateTs;
    private String description;
    private Double conversionValue;
    private Currency fromCurrency;
    private Currency toCurrency;
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
