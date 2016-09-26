package com.company.myorders.application.model;

import oracle.adfmf.java.beans.PropertyChangeListener;

import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeSupport;


public class AllTransactionDetails extends Entity {

    private BigDecimal customerTrxId;
    private String lineNumber;
    private String quantityInvoiced;
    private String description;
    private String unitSellingPrice;
    private String amount;

    public void setPropertyChangeSupport(PropertyChangeSupport _propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this._propertyChangeSupport;
        this._propertyChangeSupport = _propertyChangeSupport;
        _propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                  _propertyChangeSupport);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return _propertyChangeSupport;
    }
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);


    public BigDecimal getCustomerTrxId() {
        return this.customerTrxId;
    }

    public void setCustomerTrxId(BigDecimal customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getQuantityInvoiced() {
        return this.quantityInvoiced;
    }

    public void setQuantityInvoiced(String quantityInvoiced) {
        this.quantityInvoiced = quantityInvoiced;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitSellingPrice() {
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(String unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }
}
