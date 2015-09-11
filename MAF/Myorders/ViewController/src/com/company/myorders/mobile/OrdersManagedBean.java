package com.company.myorders.mobile;



import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class OrdersManagedBean {
    boolean getSearchStatus = false;

    public void setGetSearchStatus(boolean getSearchStatus) {
        this.getSearchStatus = getSearchStatus;
    }

    public boolean isGetSearchStatus() {
        return getSearchStatus;
    }

    public OrdersManagedBean() {
        super();
    }

    public void Logout(ActionEvent actionEvent) {
        // Add event code here...
        AdfmfJavaUtilities.logout();
    }
    public String getCurrentFeature(){
        return AdfmfJavaUtilities.getFeatureId();
    }
}
