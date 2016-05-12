package com.company.myorders.mobile;

import javax.el.ValueExpression;

import oracle.adf.model.datacontrols.device.DeviceManager;
import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.Model;

public class PushRegisterBean {
    public PushRegisterBean() {
    }

    public void registerDevice() {
        // Add event code here... 
        // Read the token provided by GCM/APNs
        ValueExpression ve1 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.deviceToken}", String.class);
        String deviceToken = (String)ve1.getValue(AdfmfJavaUtilities.getELContext());

        // Read the user id
        ValueExpression ve2 = AdfmfJavaUtilities.getValueExpression("#{securityContext.userName}", String.class);
        String userId = (String)ve2.getValue(AdfmfJavaUtilities.getELContext());
        
        // Read the GCM sender id
        ValueExpression ve3 = AdfmfJavaUtilities.getValueExpression("#{preferenceScope.application.userPref.gcmSenderId}", String.class);
        String gcmSenderId = (String)ve3.getValue(AdfmfJavaUtilities.getELContext());
        
        // Read the device type
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager();
        String deviceType = deviceManager.getOs().toLowerCase();

        // Register this user with this device for this app
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        restServiceAdapter.setConnectionName("PushServiceConn");
        restServiceAdapter.setRequestType(RestServiceAdapter.REQUEST_TYPE_GET);
        restServiceAdapter.setRetryLimit(0);
        restServiceAdapter.setRequestURI("?userId=" + userId + "&deviceToken=" + deviceToken + "&senderId=" + gcmSenderId + "&deviceType=" + deviceType);

        String response = "";
        try {
            // It's a GET request, so there's no payload
            response = restServiceAdapter.send("");
        } catch (Exception e) {
            e.printStackTrace();
            response = "Error sending registration to server. Refer to log for stack trace.";
        }

        // Write a registration response to app scope to display to the user
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{preferenceScope.application.userPref.isDeviceRegistered}", String.class);
        if (response.contains("Successfully")) {
            System.out.println("Successfully Registered");
            ve.setValue(AdfmfJavaUtilities.getELContext(), "true");
        } else {
            System.out.println("Error in Registeration");
            ve.setValue(AdfmfJavaUtilities.getELContext(), "false");
        }
        AdfmfJavaUtilities.flushDataChangeEvent();
    }
}
