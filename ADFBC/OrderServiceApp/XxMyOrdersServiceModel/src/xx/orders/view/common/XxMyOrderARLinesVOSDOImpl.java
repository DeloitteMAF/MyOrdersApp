package xx.orders.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class XxMyOrderARLinesVOSDOImpl extends SDODataObject implements XxMyOrderARLinesVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 11;

   public XxMyOrderARLinesVOSDOImpl() {}

   public java.lang.Long getCustomerTrxId() {
      return getLong(START_PROPERTY_INDEX + 0);
   }

   public void setCustomerTrxId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.math.BigDecimal getLineNumber() {
      return getBigDecimal(START_PROPERTY_INDEX + 1);
   }

   public void setLineNumber(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.math.BigDecimal getQuantityInvoiced() {
      return getBigDecimal(START_PROPERTY_INDEX + 2);
   }

   public void setQuantityInvoiced(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getDescription() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setDescription(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.math.BigDecimal getUnitSellingPrice() {
      return getBigDecimal(START_PROPERTY_INDEX + 4);
   }

   public void setUnitSellingPrice(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getStatus() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setStatus(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.math.BigDecimal getAmount() {
      return getBigDecimal(START_PROPERTY_INDEX + 6);
   }

   public void setAmount(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.String getApplicationType() {
      return getString(START_PROPERTY_INDEX + 7);
   }

   public void setApplicationType(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.sql.Timestamp getDueDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 8);
   }

   public void setDueDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public java.math.BigDecimal getInvoiceAmount() {
      return getBigDecimal(START_PROPERTY_INDEX + 9);
   }

   public void setInvoiceAmount(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

   public java.math.BigDecimal getInvoiceDueAmount() {
      return getBigDecimal(START_PROPERTY_INDEX + 10);
   }

   public void setInvoiceDueAmount(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }

   public java.lang.String getAlertFlag() {
      return getString(START_PROPERTY_INDEX + 11);
   }

   public void setAlertFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 11 , value);
   }


}

