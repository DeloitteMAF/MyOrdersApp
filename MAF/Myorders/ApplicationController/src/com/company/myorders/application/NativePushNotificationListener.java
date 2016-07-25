package com.company.myorders.application;

import java.util.HashMap;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.event.Event;
import oracle.adfmf.framework.event.EventListener;
import oracle.adfmf.framework.exception.AdfException;

public class NativePushNotificationListener implements EventListener {
    public NativePushNotificationListener() {
        super();
    }

    public void onMessage(Event event) {
        String msg = event.getPayload();
        System.out.println("#### Message from the Server :" + msg);
        
        // Parse the payload of the push notification
        HashMap payload = null;
        String pushMsg = "No message received";
        try
        {
          payload = (HashMap)JSONBeanSerializationHelper.fromJSON(HashMap.class, msg);
          pushMsg = (String)payload.get("alert");          
           if (event.getApplicationState() == event.APPLICATION_STATE_FOREGROUND){
                      String ordernum = msg.substring(msg.lastIndexOf(':'+1));
                      try {
                            OrdersManagedBean orderbean = new OrdersManagedBean();
                            orderbean.onKeyDownSearch(ordernum);
                            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.comingFromNotification}", true);
                            } catch (Exception e) {
                                AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.comingFromNotification}", false);
                                e.printStackTrace();
                                }
                  }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // Write the push message to app scope to display to the user        
        AdfmfJavaUtilities.setELValue("#{applicationScope.pushMessage}", pushMsg);
    }

    public void onError(AdfException adfException) {
        System.out.println("#### Error: " + adfException.toString());
        // Write the error into app scope        
        AdfmfJavaUtilities.setELValue("#{applicationScope.errorMessage}", adfException.toString());

    }

    public void onOpen(String token) {
        System.out.println("#### Registration token:" + token);
        // Clear error in app scope
        AdfmfJavaUtilities.setELValue("#{applicationScope.errorMessage}", null);
        
        // Write the token into app scope
        AdfmfJavaUtilities.setELValue("#{applicationScope.deviceToken}", token);
    }
}
