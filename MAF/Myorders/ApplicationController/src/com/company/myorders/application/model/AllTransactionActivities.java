package com.company.myorders.application.model;

import oracle.maf.api.cdm.persistence.model.Entity;

  
    
public class AllTransactionActivities extends Entity
{

      private String customerTrxId;
      private String applicationType;
      private String appliedAmount;
      private String applicationStatus;
      private String dueDate;
      private String invoiceTotalAmount;
      private String invoiceDueAmount;
      private String alertFlag;
  
  
  
      public String getCustomerTrxId()
    {
            return this.customerTrxId;
    }

    public void setCustomerTrxId(String customerTrxId)
    {
      this.customerTrxId = customerTrxId;
    }

      public String getApplicationType()
    {
            return this.applicationType;
    }

    public void setApplicationType(String applicationType)
    {
      this.applicationType = applicationType;
    }

      public String getAppliedAmount()
    {
            return this.appliedAmount;
    }

    public void setAppliedAmount(String appliedAmount)
    {
      this.appliedAmount = appliedAmount;
    }

      public String getApplicationStatus()
    {
            return this.applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus)
    {
      this.applicationStatus = applicationStatus;
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

      public String getInvoiceTotalAmount()
    {
            return this.invoiceTotalAmount;
    }

    public void setInvoiceTotalAmount(String invoiceTotalAmount)
    {
      this.invoiceTotalAmount = invoiceTotalAmount;
    }

      public String getInvoiceDueAmount()
    {
            return this.invoiceDueAmount;
    }

    public void setInvoiceDueAmount(String invoiceDueAmount)
    {
      this.invoiceDueAmount = invoiceDueAmount;
    }

      public String getAlertFlag()
    {
            return this.alertFlag;
    }

    public void setAlertFlag(String alertFlag)
    {
      this.alertFlag = alertFlag;
    }

    
  

}
