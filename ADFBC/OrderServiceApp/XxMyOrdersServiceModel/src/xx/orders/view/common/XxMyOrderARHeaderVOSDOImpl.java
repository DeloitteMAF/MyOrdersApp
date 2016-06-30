package xx.orders.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class XxMyOrderARHeaderVOSDOImpl extends SDODataObject implements XxMyOrderARHeaderVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 9;

   public XxMyOrderARHeaderVOSDOImpl() {}

   public java.lang.Long getCustomerTrxId() {
      return getLong(START_PROPERTY_INDEX + 0);
   }

   public void setCustomerTrxId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getTrxNumber() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setTrxNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.sql.Timestamp getTrxDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 2);
   }

   public void setTrxDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getSalesOrder() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setSalesOrder(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.sql.Timestamp getDueDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 4);
   }

   public void setDueDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.math.BigDecimal getInvoiceAmount() {
      return getBigDecimal(START_PROPERTY_INDEX + 5);
   }

   public void setInvoiceAmount(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.math.BigDecimal getAmountDue() {
      return getBigDecimal(START_PROPERTY_INDEX + 6);
   }

   public void setAmountDue(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.String getClosedFlag() {
      return getString(START_PROPERTY_INDEX + 7);
   }

   public void setClosedFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.lang.String getARAlertFlag() {
      return getString(START_PROPERTY_INDEX + 8);
   }

   public void setARAlertFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public java.util.List getXxMyOrderARLinesVO() {
      return getList(START_PROPERTY_INDEX + 9);
   }

   public void setXxMyOrderARLinesVO(java.util.List value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }


}

