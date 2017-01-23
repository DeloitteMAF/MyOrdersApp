package com.company.myorders.application.model;

import oracle.maf.api.cdm.persistence.model.Entity;
  
    
public class TransactionDetails extends Entity
{

      private String customerTrxId;
      private String lineNumber;
      private String quantityInvoiced;
      private String description;
      private String unitSellingPrice;
      private String amount;
  
  
  
      public String getCustomerTrxId()
    {
            return this.customerTrxId;
    }

    public void setCustomerTrxId(String customerTrxId)
    {
      this.customerTrxId = customerTrxId;
    }

      public String getLineNumber()
    {
            return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
      this.lineNumber = lineNumber;
    }

      public String getQuantityInvoiced()
    {
            return this.quantityInvoiced;
    }

    public void setQuantityInvoiced(String quantityInvoiced)
    {
      this.quantityInvoiced = quantityInvoiced;
    }

      public String getDescription()
    {
            return this.description;
    }

    public void setDescription(String description)
    {
      this.description = description;
    }

      public String getUnitSellingPrice()
    {
            return this.unitSellingPrice;
    }

    public void setUnitSellingPrice(String unitSellingPrice)
    {
      this.unitSellingPrice = unitSellingPrice;
    }

      public String getAmount()
    {
            return this.amount;
    }

    public void setAmount(String amount)
    {
      this.amount = amount;
    }

    
  

}
