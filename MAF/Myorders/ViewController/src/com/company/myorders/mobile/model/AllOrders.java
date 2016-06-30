package com.company.myorders.mobile.model;

import com.company.myorders.mobile.model.utility.OrdersUtilityBean;

import java.util.Arrays;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import oracle.maf.api.cdm.persistence.util.EntityUtils;
import oracle.maf.api.cdm.persistence.manager.DBPersistenceManager;
import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Locale;


public class AllOrders extends Entity {

    private String orderNumber;
    private String partyName;
    private String accountNumber;
    private String flowStatusCode;
    private String orderedDate;
    private String custPoNumber;
    private String totalOrderedValue;
    private BigDecimal headerId;
    private String currencyCode;
    private String orderAlertFlag;

    private List<AllOrderDetails> xxMyOrderDetailsVO = createIndirectList("xxMyOrderDetailsVO");
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);


    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
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

    public String getTotalOrderedValue() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        return formatter.format(new BigDecimal(this.totalOrderedValue).longValue());
    }

    public void setTotalOrderedValue(String totalOrderedValue) {
        this.totalOrderedValue = totalOrderedValue;
    }

    public BigDecimal getHeaderId() {
        return this.headerId;
    }

    public void setHeaderId(BigDecimal headerId) {
        this.headerId = headerId;
    }


    public void setXxMyOrderDetailsVO(List<AllOrderDetails> xxMyOrderDetailsVO) {
        this.xxMyOrderDetailsVO.clear();
        this.xxMyOrderDetailsVO.addAll(xxMyOrderDetailsVO);
        getProviderChangeSupport().fireProviderRefresh("xxMyOrderDetailsVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderDetailsVO(AllOrderDetails[] xxMyOrderDetailsVO) {
        setXxMyOrderDetailsVO(Arrays.asList(xxMyOrderDetailsVO));
    }

    public List<AllOrderDetails> getXxMyOrderDetailsVO() {
        return this.xxMyOrderDetailsVO;
    }


    public void addAllOrderDetails(int index, AllOrderDetails allOrderDetails) {
        allOrderDetails.setIsNewEntity(true);
        EntityUtils.generatePrimaryKeyValue(allOrderDetails, 1);
        allOrderDetails.setHeaderId(getHeaderId());
    }

    public void removeAllOrderDetails(AllOrderDetails allOrderDetails) {
        DBPersistenceManager pm = new DBPersistenceManager();
        pm.removeEntity(allOrderDetails, true);
    }


    public void setOrderAlertFlag(String orderAlertFlag) {
        String oldOrderAlertFlag = this.orderAlertFlag;
        this.orderAlertFlag = orderAlertFlag;
        _propertyChangeSupport.firePropertyChange("orderAlertFlag", oldOrderAlertFlag, orderAlertFlag);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getOrderAlertFlag() {
        return orderAlertFlag;
    }
}
