package com.company.myorders.application.model;

import oracle.maf.api.cdm.persistence.model.Entity;

       import java.math.BigDecimal;
  
    
public class Notifications extends Entity
{

      private BigDecimal orderNumber;
      private String userName;
      private String releasedFlag;
      private String processFlag;
      private String message;
      private String lastUpdateDate;
      private String lastUpdatedBy;
      private String creationDate;
      private String createdBy;
      private String lastUpdateLogin;
      private String alertType;
      private String publishedFlag;
  
  
  
      public BigDecimal getOrderNumber()
    {
            return this.orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber)
    {
      this.orderNumber = orderNumber;
    }

      public String getUserName()
    {
            return this.userName;
    }

    public void setUserName(String userName)
    {
      this.userName = userName;
    }

      public String getReleasedFlag()
    {
            return this.releasedFlag;
    }

    public void setReleasedFlag(String releasedFlag)
    {
      this.releasedFlag = releasedFlag;
    }

      public String getProcessFlag()
    {
            return this.processFlag;
    }

    public void setProcessFlag(String processFlag)
    {
      this.processFlag = processFlag;
    }

      public String getMessage()
    {
            return this.message;
    }

    public void setMessage(String message)
    {
      this.message = message;
    }

      public String getLastUpdateDate()
    {
            return this.lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate)
    {
      this.lastUpdateDate = lastUpdateDate;
    }

      public String getLastUpdatedBy()
    {
            return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy)
    {
      this.lastUpdatedBy = lastUpdatedBy;
    }

      public String getCreationDate()
    {
            return this.creationDate;
    }

    public void setCreationDate(String creationDate)
    {
      this.creationDate = creationDate;
    }

      public String getCreatedBy()
    {
            return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
      this.createdBy = createdBy;
    }

      public String getLastUpdateLogin()
    {
            return this.lastUpdateLogin;
    }

    public void setLastUpdateLogin(String lastUpdateLogin)
    {
      this.lastUpdateLogin = lastUpdateLogin;
    }

      public String getAlertType()
    {
            return this.alertType;
    }

    public void setAlertType(String alertType)
    {
      this.alertType = alertType;
    }

      public String getPublishedFlag()
    {
            return this.publishedFlag;
    }

    public void setPublishedFlag(String publishedFlag)
    {
      this.publishedFlag = publishedFlag;
    }

    
  

}
