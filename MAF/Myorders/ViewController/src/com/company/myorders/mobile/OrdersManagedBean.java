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
    private int detailRowSpacer = 15;
    private int sbRowSpacer = 10;

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
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
        AdfmfContainerUtilities.gotoFeature(currentFeature);
        AdfmfJavaUtilities.logout();
    }
    
    public void openSpringboard(ActionEvent actionEvent) {
        currentFeature = AdfmfJavaUtilities.getFeatureId();
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", true);
        AdfmfContainerUtilities.gotoSpringboard();
    }
    
    public void closeSpringBoard(ActionEvent actionEvent) {
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
        AdfmfContainerUtilities.gotoFeature(currentFeature);
    }

    public void gotoFeature(ActionEvent actionEvent) {
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
        AdfmfContainerUtilities.gotoFeature(currentFeature);
    }
    
    public void backToDashboard(ActionEvent actionEvent) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureName(),
                                                                          "adf.mf.api.amx.doNavigation",
                                                                          new Object[] { "backToDashboard" });
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setDetailRowSpacer(int detailRowSpacer) {
        this.detailRowSpacer = detailRowSpacer;
    }

    public int getDetailRowSpacer() {
        return detailRowSpacer;
    }

    public void setSbRowSpacer(int sbRowSpacer) {
        this.sbRowSpacer = sbRowSpacer;
    }

    public int getSbRowSpacer() {
        return sbRowSpacer;
    }
}
