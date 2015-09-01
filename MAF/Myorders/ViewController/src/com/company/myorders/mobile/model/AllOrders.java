package com.company.myorders.mobile.model;

import com.company.myorders.mobile.model.utility.OrdersUtilityBean;

import oracle.ateam.sample.mobile.v2.persistence.model.Entity;

import java.math.BigDecimal;


public class AllOrders extends Entity {

    private BigDecimal orderNumber;
    private String partyName;
    private String accountNumber;
    private String flowStatusCode;
    private String orderedDate;
    private String custPoNumber;
    private BigDecimal totalOrderedValue;
    private String fulfillmentDate;


    public BigDecimal getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFlowStatusCode() {
        return this.flowStatusCode;
    }

    public void setFlowStatusCode(String flowStatusCode) {
        this.flowStatusCode = flowStatusCode;
    }

    public String getOrderedDate() {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTime(this.orderedDate);
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getCustPoNumber() {
        return this.custPoNumber;
    }

    public void setCustPoNumber(String custPoNumber) {
        this.custPoNumber = custPoNumber;
    }

    public BigDecimal getTotalOrderedValue() {
        return this.totalOrderedValue;
    }

    public void setTotalOrderedValue(BigDecimal totalOrderedValue) {
        this.totalOrderedValue = totalOrderedValue;
    }

    public String getFulfillmentDate() {
        return this.fulfillmentDate;
    }

    public void setFulfillmentDate(String fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }


}
