package xx.orders.view.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class XxMyLocationsVOSDOImpl extends SDODataObject implements XxMyLocationsVOSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 1;

   public XxMyLocationsVOSDOImpl() {}

   public java.lang.String getLocationCode() {
      return getString(START_PROPERTY_INDEX + 0);
   }

   public void setLocationCode(java.lang.String value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getLocationFullName() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setLocationFullName(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }


}

