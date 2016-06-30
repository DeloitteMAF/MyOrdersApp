package xx.orders.view.common;

public interface XxMyOrderARHeaderVOSDO extends java.io.Serializable {

   public java.lang.Long getCustomerTrxId();

   public void setCustomerTrxId(java.lang.Long value);

   public java.lang.String getTrxNumber();

   public void setTrxNumber(java.lang.String value);

   public java.sql.Timestamp getTrxDate();

   public void setTrxDate(java.sql.Timestamp value);

   public java.lang.String getSalesOrder();

   public void setSalesOrder(java.lang.String value);

   public java.sql.Timestamp getDueDate();

   public void setDueDate(java.sql.Timestamp value);

   public java.math.BigDecimal getInvoiceAmount();

   public void setInvoiceAmount(java.math.BigDecimal value);

   public java.math.BigDecimal getAmountDue();

   public void setAmountDue(java.math.BigDecimal value);

   public java.lang.String getClosedFlag();

   public void setClosedFlag(java.lang.String value);

   public java.lang.String getARAlertFlag();

   public void setARAlertFlag(java.lang.String value);

   public java.util.List getXxMyOrderARLinesVO();

   public void setXxMyOrderARLinesVO(java.util.List value);


}

