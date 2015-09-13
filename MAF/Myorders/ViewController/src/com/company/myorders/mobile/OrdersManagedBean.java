package com.company.myorders.mobile;



import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class OrdersManagedBean {
    boolean getSearchStatus = false;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setGetSearchStatus(boolean getSearchStatus) {
        boolean oldGetSearchStatus = this.getSearchStatus;
        this.getSearchStatus = getSearchStatus;
        propertyChangeSupport.firePropertyChange("getSearchStatus", oldGetSearchStatus, getSearchStatus);
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

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
