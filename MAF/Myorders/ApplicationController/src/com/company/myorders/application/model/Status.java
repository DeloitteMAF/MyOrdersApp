package com.company.myorders.application.model;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Status {
    private Integer id;
    private String status;
    private String statusCode;
    private Integer count;
    private Float amount;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public Status() {
        super();
    }
    public Status(Integer id, String status, String statusCode, Integer count, Float amount) {
        this.id = id;
        this.status = status;
        this.statusCode = statusCode;
        this.count = count;
        this.amount = amount;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        _propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getStatus() {
        return status;
    }

    public void setCount(Integer count) {
        Integer oldCount = this.count;
        this.count = count;
        _propertyChangeSupport.firePropertyChange("count", oldCount, count);
    }

    public Integer getCount() {
        return count;
    }

    public void setAmount(Float amount) {
        Float oldAmount = this.amount;
        this.amount = amount;
        _propertyChangeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Float getAmount() {
        return amount;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        _propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getId() {
        return id;
    }

    public void setStatusCode(String statusCode) {
        String oldStatusCode = this.statusCode;
        this.statusCode = statusCode;
        _propertyChangeSupport.firePropertyChange("statusCode", oldStatusCode, statusCode);
    }

    public String getStatusCode() {
        return statusCode;
    }
}
