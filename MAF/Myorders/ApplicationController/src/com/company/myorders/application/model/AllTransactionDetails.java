package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;


public class AllTransactionDetails extends Entity {

    private BigDecimal customerTrxId;
    private String lineNumber;
    private String quantityInvoiced;
    private String description;
    private String unitSellingPrice;
    private String status;
    private String amount;
    private String applicationType;
    private String dueDate;
    private String invoiceAmount;
    private String invoiceDueAmount;
    private String alertFlag;


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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApplicationType() {
        return this.applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getDueDate() {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.dueDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceAmount() {
        return this.invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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


}
