package com.company.myorders.mobile;



import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class OrdersManagedBean {
    boolean getSearchStatus = false;
    String currentFeature;
    boolean springBoardStatus = false;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setGetSearchStatus(boolean getSearchStatus) {
        boolean oldGetSearchStatus = this.getSearchStatus;
        this.getSearchStatus = getSearchStatus;
        propertyChangeSupport.firePropertyChange("getSearchStatus", oldGetSearchStatus, getSearchStatus);
    }

    public boolean isGetSearchStatus() {
        return getSearchStatus;
    }

    public void setCurrentFeature(String currentFeature) {
        String oldCurrentFeature = this.currentFeature;
        this.currentFeature = currentFeature;
        propertyChangeSupport.firePropertyChange("currentFeature", oldCurrentFeature, currentFeature);
    }

    public String getCurrentFeature() {
        return currentFeature;
    }

    public void setSpringBoardStatus(boolean springBoardStatus) {
        boolean oldSpringBoardStatus = this.springBoardStatus;
        this.springBoardStatus = springBoardStatus;
        propertyChangeSupport.firePropertyChange("springBoardStatus", oldSpringBoardStatus, springBoardStatus);
    }

    public boolean isSpringBoardStatus() {
        return springBoardStatus;
    }

    public OrdersManagedBean() {
        super();
    }

    public void Logout(ActionEvent actionEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
        AdfmfJavaUtilities.logout();
    }
    
    public void openSpringboard(ActionEvent actionEvent) {
        // Add event code here...
        currentFeature = AdfmfJavaUtilities.getFeatureId();
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", true);
        AdfmfContainerUtilities.gotoSpringboard();
    }
    
    public void closeSpringBoard(ActionEvent actionEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
        AdfmfContainerUtilities.gotoFeature(currentFeature);
    }

    public void gotoFeature(ActionEvent actionEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
     //   AdfmfContainerUtilities.gotoFeature(currentFeature);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
