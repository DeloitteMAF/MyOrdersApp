package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import oracle.maf.api.cdm.persistence.model.Entity;


public class AllTransactionActivities extends Entity {

    private BigDecimal customerTrxId;
    private String applicationType;
    private String appliedAmount;
    private String ApplicationStatus;
    private String dueDate;
    private String invoiceTotalAmount;
    private String invoiceDueAmount;
    private String alertFlag;
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);


    public BigDecimal getCustomerTrxId() {
        return this.customerTrxId;
    }

    public void setCustomerTrxId(BigDecimal customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public String getApplicationType() {
        return this.applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getAppliedAmount() {
        return this.appliedAmount;
    }

    public void setAppliedAmount(String appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public String getDueDate() {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.dueDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceTotalAmount() {
        return this.invoiceTotalAmount;
    }

    public void setInvoiceTotalAmount(String invoiceTotalAmount) {
        this.invoiceTotalAmount = invoiceTotalAmount;
    }

    public String getInvoiceDueAmount() {
        return this.invoiceDueAmount;
    }

    public void setInvoiceDueAmount(String invoiceDueAmount) {
        this.invoiceDueAmount = invoiceDueAmount;
    }

    public String getAlertFlag() {
        return this.alertFlag;
    }

    public void setAlertFlag(String alertFlag) {
        this.alertFlag = alertFlag;
    }


    public void setPropertyChangeSupport(PropertyChangeSupport _propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this._propertyChangeSupport;
        this._propertyChangeSupport = _propertyChangeSupport;
        _propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                  _propertyChangeSupport);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return _propertyChangeSupport;
    }

    public void setApplicationStatus(String ApplicationStatus) {
        String oldApplicationStatus = this.ApplicationStatus;
        this.ApplicationStatus = ApplicationStatus;
        _propertyChangeSupport.firePropertyChange("applicationStatus", oldApplicationStatus, ApplicationStatus);
    }

    public String getApplicationStatus() {
        return ApplicationStatus;
    }
}
