package com.company.myorders.mobile;



import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class OrdersManagedBean {
    public OrdersManagedBean() {
        super();
    }

    public void Logout(ActionEvent actionEvent) {
        // Add event code here...
        AdfmfJavaUtilities.logout();
    }
}
