package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import java.util.Arrays;
import java.util.List;

import oracle.maf.api.cdm.persistence.util.EntityUtils;
import oracle.maf.api.cdm.persistence.manager.DBPersistenceManager;
import oracle.maf.api.cdm.persistence.model.Entity;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeSupport;


public class Transactions extends Entity {

    private BigDecimal customerTrxId;
    private String trxType;
    private String trxNumber;
    private String trxDate;
    private String salesOrder;
    private String invoiceAmount;
    private String amountDue;
    private String transactionAppliedAmt;
    private String trxStatus;
    private String dueDate;
    private String closedFlag;
    private String billToAddress;
    private String remitToAddress;
    private String currencyCode;
    private String aRAlertFlag;
    private String lineCount;

    private List<TransactionDetails> xxMyOrderARLinesVO = createIndirectList("xxMyOrderARLinesVO");
    private List<TransactionActivities> xxMyOrderARActivitiesVO = createIndirectList("xxMyOrderARActivitiesVO");
    private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);


    public BigDecimal getCustomerTrxId() {
        return this.customerTrxId;
    }

    public void setCustomerTrxId(BigDecimal customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public String getTrxType() {
        return this.trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public String getTrxNumber() {
        return this.trxNumber;
    }

    public void setTrxNumber(String trxNumber) {
        this.trxNumber = trxNumber;
    }

    public String getTrxDate() {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.trxDate);
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getSalesOrder() {
        return this.salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getInvoiceAmount() {
        return this.invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getAmountDue() {
        return this.amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }

    public String getTransactionAppliedAmt() {
        return this.transactionAppliedAmt;
    }

    public void setTransactionAppliedAmt(String transactionAppliedAmt) {
        this.transactionAppliedAmt = transactionAppliedAmt;
    }

    public String getTrxStatus() {
        return this.trxStatus;
    }

    public void setTrxStatus(String trxStatus) {
        this.trxStatus = trxStatus;
    }

    public String getDueDate() {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.dueDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getClosedFlag() {
        return this.closedFlag;
    }

    public void setClosedFlag(String closedFlag) {
        this.closedFlag = closedFlag;
    }

    public String getBillToAddress() {
        return this.billToAddress;
    }

    public void setBillToAddress(String billToAddress) {
        this.billToAddress = billToAddress;
    }

    public String getRemitToAddress() {
        return this.remitToAddress;
    }

    public void setRemitToAddress(String remitToAddress) {
        this.remitToAddress = remitToAddress;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getARAlertFlag() {
        return this.aRAlertFlag;
    }

    public void setARAlertFlag(String aRAlertFlag) {
        this.aRAlertFlag = aRAlertFlag;
    }

    public String getLineCount() {
        return this.lineCount;
    }

    public void setLineCount(String lineCount) {
        this.lineCount = lineCount;
    }


    public void setXxMyOrderARLinesVO(List<TransactionDetails> xxMyOrderARLinesVO) {
        this.xxMyOrderARLinesVO.clear();
        this.xxMyOrderARLinesVO.addAll(xxMyOrderARLinesVO);
        getProviderChangeSupport().fireProviderRefresh("xxMyOrderARLinesVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderARLinesVO(TransactionDetails[] xxMyOrderARLinesVO) {
        setXxMyOrderARLinesVO(Arrays.asList(xxMyOrderARLinesVO));
    }

    public List<TransactionDetails> getXxMyOrderARLinesVO() {
        return this.xxMyOrderARLinesVO;
    }


    /**
     * This method is automatically called when using the Create operation on the transactionDetails collection
     * in the data control palette.
     *
     * Note that this method does NOT add the transactionDetails to the entity list because this method is
     * automatically called by MAF framework when using the Create operation from the data control palette.
     * MAF will add the entity to the list AFTER this method has been executed.
     *
     * You can use this method to set default values.
     * If you want to refresh data in the UI based on the size of the transactionDetails list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityAdded and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a transactionDetails has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Create operation
     * instead to ensure that iterator binding and transactionDetails list stay in sync.
     * @param index
     * @param transactionDetails
     */
    public void addTransactionDetails(int index, TransactionDetails transactionDetails) {
        transactionDetails.setIsNewEntity(true);
        transactionDetails.setCustomerTrxId(getCustomerTrxId());
    }

    /**
     * This method is automatically called when using the Delete operation on the transactionDetails collection
     * in the data control palette. It deletes the corresponding row from the database (if persisted) and
     * calls the configured remove method on the remote persistence manager if applicable.
     *
     * Note that this method does NOT remove the transactionDetails from the transactionDetails list because this method is
     * automatically called by MAF framework when using the Delete operation from the data control palette.
     * MAF will remove the entity from the list AFTER this method has been executed.
     *
     * If you want to refresh data in the UI based on the size of the transactionDetails list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityTRemoved and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a transactionDetails has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Delete operation
     * instead to ensure that iterator binding and transactionDetails list stay in sync.
     * @param transactionDetails
     */
    public void removeTransactionDetails(TransactionDetails transactionDetails) {
        DBPersistenceManager pm = new DBPersistenceManager();
        pm.removeEntity(transactionDetails, true);
    }


    public void setXxMyOrderARActivitiesVO(List<TransactionActivities> xxMyOrderARActivitiesVO) {
        this.xxMyOrderARActivitiesVO.clear();
        this.xxMyOrderARActivitiesVO.addAll(xxMyOrderARActivitiesVO);
        getProviderChangeSupport().fireProviderRefresh("xxMyOrderARActivitiesVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderARActivitiesVO(TransactionActivities[] xxMyOrderARActivitiesVO) {
        setXxMyOrderARActivitiesVO(Arrays.asList(xxMyOrderARActivitiesVO));
    }

    public List<TransactionActivities> getXxMyOrderARActivitiesVO() {
        return this.xxMyOrderARActivitiesVO;
    }


    /**
     * This method is automatically called when using the Create operation on the transactionActivities collection
     * in the data control palette.
     *
     * Note that this method does NOT add the transactionActivities to the entity list because this method is
     * automatically called by MAF framework when using the Create operation from the data control palette.
     * MAF will add the entity to the list AFTER this method has been executed.
     *
     * You can use this method to set default values.
     * If you want to refresh data in the UI based on the size of the transactionActivities list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityAdded and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a transactionActivities has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Create operation
     * instead to ensure that iterator binding and transactionActivities list stay in sync.
     * @param index
     * @param transactionActivities
     */
    public void addTransactionActivities(int index, TransactionActivities transactionActivities) {
        transactionActivities.setIsNewEntity(true);
        transactionActivities.setCustomerTrxId(getCustomerTrxId());
    }

    /**
     * This method is automatically called when using the Delete operation on the transactionActivities collection
     * in the data control palette. It deletes the corresponding row from the database (if persisted) and
     * calls the configured remove method on the remote persistence manager if applicable.
     *
     * Note that this method does NOT remove the transactionActivities from the transactionActivities list because this method is
     * automatically called by MAF framework when using the Delete operation from the data control palette.
     * MAF will remove the entity from the list AFTER this method has been executed.
     *
     * If you want to refresh data in the UI based on the size of the transactionActivities list, then you cannot do this in this
     * method because the list is not updated yet (see above), instead override method childEntityTRemoved and add your
     * logic there. The CDM IndirectList class ensures that this method is called after a transactionActivities has been added.
     *
     * Do NOT drag and drop this method from the data control palette, use the Delete operation
     * instead to ensure that iterator binding and transactionActivities list stay in sync.
     * @param transactionActivities
     */
    public void removeTransactionActivities(TransactionActivities transactionActivities) {
        DBPersistenceManager pm = new DBPersistenceManager();
        pm.removeEntity(transactionActivities, true);
    }


    public void setPropertyChangeSupport(PropertyChangeSupport _propertyChangeSupport) {
        this._propertyChangeSupport = _propertyChangeSupport;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return _propertyChangeSupport;
    }
}
