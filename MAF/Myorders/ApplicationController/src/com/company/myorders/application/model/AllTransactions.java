package com.company.myorders.application.model;

import com.company.myorders.application.model.utility.OrdersUtilityBean;

import java.util.Arrays;
import java.util.List;
import oracle.maf.api.cdm.persistence.util.EntityUtils;
import oracle.maf.api.cdm.persistence.manager.DBPersistenceManager;
import oracle.maf.api.cdm.persistence.model.Entity;

       import java.math.BigDecimal;
  
                        
public class AllTransactions extends Entity
{

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
  
      private List<AllTransactionDetails> xxMyOrderARLinesVO = createIndirectList("xxMyOrderARLinesVO");
      private List<AllTransactionActivities> xxMyOrderARActivitiesVO = createIndirectList("xxMyOrderARActivitiesVO");
  
  
      public BigDecimal getCustomerTrxId()
    {
            return this.customerTrxId;
    }

    public void setCustomerTrxId(BigDecimal customerTrxId)
    {
      this.customerTrxId = customerTrxId;
    }

      public String getTrxType()
    {
            return this.trxType;
    }

    public void setTrxType(String trxType)
    {
      this.trxType = trxType;
    }

      public String getTrxNumber()
    {
            return this.trxNumber;
    }

    public void setTrxNumber(String trxNumber)
    {
      this.trxNumber = trxNumber;
    }

      public String getTrxDate()
    {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.trxDate);
    }

    public void setTrxDate(String trxDate)
    {
      this.trxDate = trxDate;
    }

      public String getSalesOrder()
    {
            return this.salesOrder;
    }

    public void setSalesOrder(String salesOrder)
    {
      this.salesOrder = salesOrder;
    }

      public String getInvoiceAmount()
    {
            return this.invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount)
    {
      this.invoiceAmount = invoiceAmount;
    }

      public String getAmountDue()
    {
            return this.amountDue;
    }

    public void setAmountDue(String amountDue)
    {
      this.amountDue = amountDue;
    }

      public String getTransactionAppliedAmt()
    {
            return this.transactionAppliedAmt;
    }

    public void setTransactionAppliedAmt(String transactionAppliedAmt)
    {
      this.transactionAppliedAmt = transactionAppliedAmt;
    }

      public String getTrxStatus()
    {
            return this.trxStatus;
    }

    public void setTrxStatus(String trxStatus)
    {
      this.trxStatus = trxStatus;
    }

      public String getDueDate()
    {
        OrdersUtilityBean ordersUtilityBean=new OrdersUtilityBean();
        return ordersUtilityBean.toDateTimeTZ(this.dueDate);
    }

    public void setDueDate(String dueDate)
    {
      this.dueDate = dueDate;
    }

      public String getClosedFlag()
    {
            return this.closedFlag;
    }

    public void setClosedFlag(String closedFlag)
    {
      this.closedFlag = closedFlag;
    }

      public String getBillToAddress()
    {
            return this.billToAddress;
    }

    public void setBillToAddress(String billToAddress)
    {
      this.billToAddress = billToAddress;
    }

      public String getRemitToAddress()
    {
            return this.remitToAddress;
    }

    public void setRemitToAddress(String remitToAddress)
    {
      this.remitToAddress = remitToAddress;
    }

      public String getCurrencyCode()
    {
            return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode)
    {
      this.currencyCode = currencyCode;
    }

      public String getARAlertFlag()
    {
            return this.aRAlertFlag;
    }

    public void setARAlertFlag(String aRAlertFlag)
    {
      this.aRAlertFlag = aRAlertFlag;
    }

      public String getLineCount()
    {
            return this.lineCount;
    }

    public void setLineCount(String lineCount)
    {
      this.lineCount = lineCount;
    }

    
    public void setXxMyOrderARLinesVO(List<AllTransactionDetails> xxMyOrderARLinesVO)
    {
      this.xxMyOrderARLinesVO.clear();
      this.xxMyOrderARLinesVO.addAll(xxMyOrderARLinesVO);
      getProviderChangeSupport().fireProviderRefresh("xxMyOrderARLinesVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderARLinesVO(AllTransactionDetails[] xxMyOrderARLinesVO)
    {
      setXxMyOrderARLinesVO(Arrays.asList(xxMyOrderARLinesVO));
    }

    public List<AllTransactionDetails> getXxMyOrderARLinesVO()
    {
      return this.xxMyOrderARLinesVO;
    }


  /**
   * This method is automatically called when using the Create operation on the allTransactionDetails collection
   * in the data control palette. 
   * 
   * Note that this method does NOT add the allTransactionDetails to the entity list because this method is 
   * automatically called by MAF framework when using the Create operation from the data control palette. 
   * MAF will add the entity to the list AFTER this method has been executed. 
   * 
   * You can use this method to set default values. 
   * If you want to refresh data in the UI based on the size of the allTransactionDetails list, then you cannot do this in this
   * method because the list is not updated yet (see above), instead override method childEntityAdded and add your 
   * logic there. The CDM IndirectList class ensures that this method is called after a allTransactionDetails has been added.
   * 
   * Do NOT drag and drop this method from the data control palette, use the Create operation 
   * instead to ensure that iterator binding and allTransactionDetails list stay in sync.
   * @param index
   * @param allTransactionDetails
   */
  public void addAllTransactionDetails(int index, AllTransactionDetails allTransactionDetails)
  {
    allTransactionDetails.setIsNewEntity(true);
         allTransactionDetails.setCustomerTrxId(getCustomerTrxId());
      }

  /**
   * This method is automatically called when using the Delete operation on the allTransactionDetails collection
   * in the data control palette. It deletes the corresponding row from the database (if persisted) and 
   * calls the configured remove method on the remote persistence manager if applicable.
   * 
   * Note that this method does NOT remove the allTransactionDetails from the allTransactionDetails list because this method is 
   * automatically called by MAF framework when using the Delete operation from the data control palette. 
   * MAF will remove the entity from the list AFTER this method has been executed. 
   * 
   * If you want to refresh data in the UI based on the size of the allTransactionDetails list, then you cannot do this in this
   * method because the list is not updated yet (see above), instead override method childEntityTRemoved and add your 
   * logic there. The CDM IndirectList class ensures that this method is called after a allTransactionDetails has been added.
   *   
   * Do NOT drag and drop this method from the data control palette, use the Delete operation 
   * instead to ensure that iterator binding and allTransactionDetails list stay in sync.
   * @param allTransactionDetails
   */
  public void removeAllTransactionDetails(AllTransactionDetails allTransactionDetails)
  {
          DBPersistenceManager pm = new DBPersistenceManager();
      pm.removeEntity(allTransactionDetails, true);
      }

  
    public void setXxMyOrderARActivitiesVO(List<AllTransactionActivities> xxMyOrderARActivitiesVO)
    {
      this.xxMyOrderARActivitiesVO.clear();
      this.xxMyOrderARActivitiesVO.addAll(xxMyOrderARActivitiesVO);
      getProviderChangeSupport().fireProviderRefresh("xxMyOrderARActivitiesVO");
    }

    /**
     * This method is called when entity instance is recreated from persisted JSON string in DataSynchAction
     */
    public void setXxMyOrderARActivitiesVO(AllTransactionActivities[] xxMyOrderARActivitiesVO)
    {
      setXxMyOrderARActivitiesVO(Arrays.asList(xxMyOrderARActivitiesVO));
    }

    public List<AllTransactionActivities> getXxMyOrderARActivitiesVO()
    {
      return this.xxMyOrderARActivitiesVO;
    }


  /**
   * This method is automatically called when using the Create operation on the allTransactionActivities collection
   * in the data control palette. 
   * 
   * Note that this method does NOT add the allTransactionActivities to the entity list because this method is 
   * automatically called by MAF framework when using the Create operation from the data control palette. 
   * MAF will add the entity to the list AFTER this method has been executed. 
   * 
   * You can use this method to set default values. 
   * If you want to refresh data in the UI based on the size of the allTransactionActivities list, then you cannot do this in this
   * method because the list is not updated yet (see above), instead override method childEntityAdded and add your 
   * logic there. The CDM IndirectList class ensures that this method is called after a allTransactionActivities has been added.
   * 
   * Do NOT drag and drop this method from the data control palette, use the Create operation 
   * instead to ensure that iterator binding and allTransactionActivities list stay in sync.
   * @param index
   * @param allTransactionActivities
   */
  public void addAllTransactionActivities(int index, AllTransactionActivities allTransactionActivities)
  {
    allTransactionActivities.setIsNewEntity(true);
         allTransactionActivities.setCustomerTrxId(getCustomerTrxId().toString());
      }

  /**
   * This method is automatically called when using the Delete operation on the allTransactionActivities collection
   * in the data control palette. It deletes the corresponding row from the database (if persisted) and 
   * calls the configured remove method on the remote persistence manager if applicable.
   * 
   * Note that this method does NOT remove the allTransactionActivities from the allTransactionActivities list because this method is 
   * automatically called by MAF framework when using the Delete operation from the data control palette. 
   * MAF will remove the entity from the list AFTER this method has been executed. 
   * 
   * If you want to refresh data in the UI based on the size of the allTransactionActivities list, then you cannot do this in this
   * method because the list is not updated yet (see above), instead override method childEntityTRemoved and add your 
   * logic there. The CDM IndirectList class ensures that this method is called after a allTransactionActivities has been added.
   *   
   * Do NOT drag and drop this method from the data control palette, use the Delete operation 
   * instead to ensure that iterator binding and allTransactionActivities list stay in sync.
   * @param allTransactionActivities
   */
  public void removeAllTransactionActivities(AllTransactionActivities allTransactionActivities)
  {
          DBPersistenceManager pm = new DBPersistenceManager();
      pm.removeEntity(allTransactionActivities, true);
      }

  
  

}
