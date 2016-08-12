package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;


public class AllOrderDetails extends Entity {

    private BigDecimal headerId;
    private BigDecimal lineId;
    private String lineNumber;
    private String orderedItem;
    private String description;
    private String lineStatus;
    private String orderedQuantity;
    private String orderQuantityUom;
    private String shippedQuantity;
    private String shippingQuantityUom;
    private String unitSellingPrice;
    private String lineTotal;
    private String deliveryName;
    private String freightCode;
    private String actualArrivalDate;
    private String backorderQuantity;
    private String address;
    private String shipToContact;
    private String alertFlag;
    private String currencyCode;


    public BigDecimal getHeaderId() {
        return this.headerId;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setHeaderId(BigDecimal headerId) {
        this.headerId = headerId;
    }

    public BigDecimal getLineId() {
        return this.lineId;
    }

    public void setLineId(BigDecimal lineId) {
        this.lineId = lineId;
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getOrderedItem() {
        return this.orderedItem;
    }

    public void setOrderedItem(String orderedItem) {
        this.orderedItem = orderedItem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLineStatus() {
        return this.lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }

    public String getOrderedQuantity() {
        return this.orderedQuantity;
    }

    public void setOrderedQuantity(String orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public String getOrderQuantityUom() {
        return this.orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public String getShippedQuantity() {
        return this.shippedQuantity;
    }

    public void setShippedQuantity(String shippedQuantity) {
        this.shippedQuantity = shippedQuantity;
    }

    public String getShippingQuantityUom() {
        return this.shippingQuantityUom;
    }

    public void setShippingQuantityUom(String shippingQuantityUom) {
        this.shippingQuantityUom = shippingQuantityUom;
    }

    public String getUnitSellingPrice() {
        return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(String unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getLineTotal() {
        return this.lineTotal;
    }

    public void setLineTotal(String lineTotal) {
        this.lineTotal = lineTotal;
    }

    public String getDeliveryName() {
        return this.deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getFreightCode() {
        return this.freightCode;
    }

    public void setFreightCode(String freightCode) {
        this.freightCode = freightCode;
    }

    public String getActualArrivalDate() {  
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
            return ordersUtilityBean.toDateTimeTZ(this.actualArrivalDate);       
    }

    public void setActualArrivalDate(String actualArrivalDate) {
        this.actualArrivalDate = actualArrivalDate;
    }

    public String getBackorderQuantity() {
        return this.backorderQuantity;
    }

    public void setBackorderQuantity(String backorderQuantity) {
        this.backorderQuantity = backorderQuantity;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipToContact() {
        return this.shipToContact;
    }

    public void setShipToContact(String shipToContact) {
        this.shipToContact = shipToContact;
    }

    public void setAlertFlag(String alertFlag) {
        this.alertFlag = alertFlag;
    }

    public String getAlertFlag() {
        return alertFlag;
    }


}
