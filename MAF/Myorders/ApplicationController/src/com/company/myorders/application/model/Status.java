package com.company.myorders.application.model;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Status {
    private String status;
    private Integer count;
    private Float amount;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public Status() {
        super();
    }
    public Status(String status, Integer count, Float amount) {
        this.status = status;
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
}
