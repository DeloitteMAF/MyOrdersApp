package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;


public class AllTransactionDetails extends Entity {

    private BigDecimal customerTrxId;
    private BigDecimal lineNumber;
    private BigDecimal quantityInvoiced;
    private String description;
    private BigDecimal unitSellingPrice;
    private String status;
    private BigDecimal amount;
    private String applicationType;
    private String dueDate;
    private BigDecimal invoiceAmount;
    private BigDecimal invoiceDueAmount;
    private String alertFlag;


    public BigDecimal getCustomerTrxId() {
        return this.customerTrxId;
    }

    public void setCustomerTrxId(BigDecimal customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public BigDecimal getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BigDecimal getQuantityInvoiced() {
        return this.quantityInvoiced;
    }

    public void setQuantityInvoiced(BigDecimal quantityInvoiced) {
        this.quantityInvoiced = quantityInvoiced;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitSellingPrice() {
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public BigDecimal getInvoiceAmount() {
        return this.invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getInvoiceDueAmount() {
        return this.invoiceDueAmount;
    }

    public void setInvoiceDueAmount(BigDecimal invoiceDueAmount) {
        this.invoiceDueAmount = invoiceDueAmount;
    }

    public String getAlertFlag() {
        return this.alertFlag;
    }

    public void setAlertFlag(String alertFlag) {
        this.alertFlag = alertFlag;
    }


}
