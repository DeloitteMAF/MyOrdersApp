package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

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


public class Orders extends Entity {

    private String orderNumber;
    private String customer;
    private String customerNumber;
    private String flowStatusCode;
    private String orderedDate;
    private String custPoNumber;
    private String totalActual;
    private String total;
    private String subTotal;
    private String tax;
    private String charges;
    private String contact;
    private String contactName;
    private String emailAddres;
    private String phoneNumber;
    private String headerId;
    private String currencyCode;
    private String orderAlertFlag;

    private List<OrderDetails> xxMyOrderDetailsVO = createIndirectList("xxMyOrderDetailsVO");
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

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
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

    public String getTotalActual() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        return formatter.format(new BigDecimal(this.totalActual).longValue());
    }

    public void setTotalActual(String totalActual) {
        this.totalActual = totalActual;
    }

    public String getHeaderId() {
        return this.headerId;
    }

    public void setHeaderId(String headerId) {
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

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getCharges() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        return formatter.format(new BigDecimal(this.charges).longValue());
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getSubTotal() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        return formatter.format(new BigDecimal(this.subTotal).longValue());
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTax() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        return formatter.format(new BigDecimal(this.tax).longValue());
    }
}
