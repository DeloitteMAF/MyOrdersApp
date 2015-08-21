package xx.orders.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class XxMyOrdersVOSDOImpl extends SDODataObject implements XxMyOrdersVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 7;

   public XxMyOrdersVOSDOImpl() {}

   public java.math.BigDecimal getOrderNumber() {
      return getBigDecimal(START_PROPERTY_INDEX + 0);
   }

   public void setOrderNumber(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getPartyName() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setPartyName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.lang.String getAccountNumber() {
      return getString(START_PROPERTY_INDEX + 2);
   }

   public void setAccountNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getFlowStatusCode() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setFlowStatusCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.lang.String getOrderedDate() {
      return getString(START_PROPERTY_INDEX + 4);
   }

   public void setOrderedDate(java.lang.String value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getCustPoNumber() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setCustPoNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.math.BigDecimal getTotalOrderedValue() {
      return getBigDecimal(START_PROPERTY_INDEX + 6);
   }

   public void setTotalOrderedValue(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.String getFulfillmentDate() {
      return getString(START_PROPERTY_INDEX + 7);
   }

   public void setFulfillmentDate(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }


}

