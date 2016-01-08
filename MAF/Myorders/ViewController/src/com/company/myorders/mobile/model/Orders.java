package com.company.myorders.mobile.model;

import com.company.myorders.mobile.model.utility.OrdersUtilityBean;

import java.util.Arrays;
import java.util.List;

import oracle.ateam.sample.mobile.v2.persistence.util.EntityUtils;
import oracle.ateam.sample.mobile.v2.persistence.manager.DBPersistenceManager;
import oracle.ateam.sample.mobile.v2.persistence.model.Entity;

import java.math.BigDecimal;


public class Orders extends Entity {

    private BigDecimal orderNumber;
    private String partyName;
    private String accountNumber;
    private String flowStatusCode;
    private String orderedDate;
    private String custPoNumber;
    private BigDecimal totalOrderedValue;
    private BigDecimal headerId;
    private String currencyCode;

    private List<OrderDetails> xxMyOrderDetailsVO = createIndirectList("xxMyOrderDetailsVO");


    public BigDecimal getOrderNumber() {
        return this.orderNumber;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
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

    public BigDecimal getHeaderId() {
        return this.headerId;
    }

    public void setHeaderId(BigDecimal headerId) {
        this.headerId = headerId;
    }


    public void setXxMyOrderDetailsVO(List<OrderDetails> xxMyOrderDetailsVO) {
        this.xxMyOrderDetailsVO.clear();
        this.xxMyOrderDetailsVO.addAll(xxMyOrderDetailsVO);
        getProviderChangeSupport().fireProviderRefresh("xxMyOrderDetailsVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderDetailsVO(OrderDetails[] xxMyOrderDetailsVO) {
        setXxMyOrderDetailsVO(Arrays.asList(xxMyOrderDetailsVO));
    }

    public List<OrderDetails> getXxMyOrderDetailsVO() {
        return this.xxMyOrderDetailsVO;
    }


    public void addOrderDetails(int index, OrderDetails orderDetails) {
        orderDetails.setIsNewEntity(true);
        EntityUtils.generatePrimaryKeyValue(orderDetails, 1);
        orderDetails.setHeaderId(getHeaderId());
    }

    public void removeOrderDetails(OrderDetails orderDetails) {
        DBPersistenceManager pm = new DBPersistenceManager();
        pm.removeEntity(orderDetails, true);
    }


}
