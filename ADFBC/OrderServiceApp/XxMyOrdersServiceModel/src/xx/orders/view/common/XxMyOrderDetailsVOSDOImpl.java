package xx.orders.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class XxMyOrderDetailsVOSDOImpl extends SDODataObject implements XxMyOrderDetailsVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 20;

   public XxMyOrderDetailsVOSDOImpl() {}

   public java.math.BigDecimal getHeaderId() {
      return getBigDecimal(START_PROPERTY_INDEX + 0);
   }

   public void setHeaderId(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.Long getLineId() {
      return getLong(START_PROPERTY_INDEX + 1);
   }

   public void setLineId(java.lang.Long value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }

   public java.lang.String getLineNumber() {
      return getString(START_PROPERTY_INDEX + 2);
   }

   public void setLineNumber(java.lang.String value) {
      set(START_PROPERTY_INDEX + 2 , value);
   }

   public java.lang.String getOrderedItem() {
      return getString(START_PROPERTY_INDEX + 3);
   }

   public void setOrderedItem(java.lang.String value) {
      set(START_PROPERTY_INDEX + 3 , value);
   }

   public java.lang.String getDescription() {
      return getString(START_PROPERTY_INDEX + 4);
   }

   public void setDescription(java.lang.String value) {
      set(START_PROPERTY_INDEX + 4 , value);
   }

   public java.lang.String getLineStatus() {
      return getString(START_PROPERTY_INDEX + 5);
   }

   public void setLineStatus(java.lang.String value) {
      set(START_PROPERTY_INDEX + 5 , value);
   }

   public java.math.BigDecimal getOrderedQuantity() {
      return getBigDecimal(START_PROPERTY_INDEX + 6);
   }

   public void setOrderedQuantity(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 6 , value);
   }

   public java.lang.String getOrderQuantityUom() {
      return getString(START_PROPERTY_INDEX + 7);
   }

   public void setOrderQuantityUom(java.lang.String value) {
      set(START_PROPERTY_INDEX + 7 , value);
   }

   public java.math.BigDecimal getShippedQuantity() {
      return getBigDecimal(START_PROPERTY_INDEX + 8);
   }

   public void setShippedQuantity(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 8 , value);
   }

   public java.lang.String getShippingQuantityUom() {
      return getString(START_PROPERTY_INDEX + 9);
   }

   public void setShippingQuantityUom(java.lang.String value) {
      set(START_PROPERTY_INDEX + 9 , value);
   }

   public java.math.BigDecimal getUnitSellingPrice() {
      return getBigDecimal(START_PROPERTY_INDEX + 10);
   }

   public void setUnitSellingPrice(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 10 , value);
   }

   public java.math.BigDecimal getLineTotal() {
      return getBigDecimal(START_PROPERTY_INDEX + 11);
   }

   public void setLineTotal(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 11 , value);
   }

   public java.lang.String getDeliveryName() {
      return getString(START_PROPERTY_INDEX + 12);
   }

   public void setDeliveryName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 12 , value);
   }

   public java.lang.String getFreightCode() {
      return getString(START_PROPERTY_INDEX + 13);
   }

   public void setFreightCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 13 , value);
   }

   public java.sql.Timestamp getActualArrivalDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 14);
   }

   public void setActualArrivalDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 14 , value);
   }

   public java.math.BigDecimal getBackorderQuantity() {
      return getBigDecimal(START_PROPERTY_INDEX + 15);
   }

   public void setBackorderQuantity(java.math.BigDecimal value) {
      set(START_PROPERTY_INDEX + 15 , value);
   }

   public java.lang.String getAddress() {
      return getString(START_PROPERTY_INDEX + 16);
   }

   public void setAddress(java.lang.String value) {
      set(START_PROPERTY_INDEX + 16 , value);
   }

   public java.lang.String getShipToContact() {
      return getString(START_PROPERTY_INDEX + 17);
   }

   public void setShipToContact(java.lang.String value) {
      set(START_PROPERTY_INDEX + 17 , value);
   }

   public java.lang.String getAlertFlag() {
      return getString(START_PROPERTY_INDEX + 18);
   }

   public void setAlertFlag(java.lang.String value) {
      set(START_PROPERTY_INDEX + 18 , value);
   }

   public java.lang.String getCurrencyCode() {
      return getString(START_PROPERTY_INDEX + 19);
   }

   public void setCurrencyCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 19 , value);
   }

   public java.sql.Timestamp getFulfillmentDate() {
      return (java.sql.Timestamp)get(START_PROPERTY_INDEX + 20);
   }

   public void setFulfillmentDate(java.sql.Timestamp value) {
      set(START_PROPERTY_INDEX + 20 , value);
   }


}

