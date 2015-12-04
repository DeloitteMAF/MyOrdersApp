package com.company.myorders.mobile;


import com.company.myorders.mobile.model.OrderDetails;

import java.util.ArrayList;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxIteratorBinding;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.util.GenericType;

public class OrdersManagedBean {
    boolean getSearchStatus = false;
    boolean clearSearch = true;
    String currentFeature;
    boolean springBoardStatus = false;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private int detailRowSpacer = 15;
    private int sbRowSpacer = 10;
    private Boolean isRefreshComplete=false;
    private transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public void setGetSearchStatus(boolean getSearchStatus) {
        boolean oldGetSearchStatus = this.getSearchStatus;
        this.getSearchStatus = getSearchStatus;
        propertyChangeSupport.firePropertyChange("getSearchStatus", oldGetSearchStatus, getSearchStatus);
    }


    public void setClearSearch(boolean clearSearch) {
        boolean oldClearSearch = this.clearSearch;
        this.clearSearch = clearSearch;
        propertyChangeSupport.firePropertyChange("clearSearch", oldClearSearch, clearSearch);
    }

    public boolean isClearSearch() {
        return clearSearch;
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
//        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.springBoardStatus}", false);
//        AdfmfContainerUtilities.gotoFeature(currentFeature);
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
    
    public void backToDetails(ActionEvent actionEvent) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureName(),
                                                                          "adf.mf.api.amx.doNavigation",
                                                                          new Object[] { "backToDetails" });
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

    public void setIsRefreshComplete(Boolean isRefreshComplete) {
        Boolean oldIsRefreshComplete = this.isRefreshComplete;
        this.isRefreshComplete = isRefreshComplete;
        propertyChangeSupport.firePropertyChange("isRefreshComplete", oldIsRefreshComplete, isRefreshComplete);
    }

    public Boolean getIsRefreshComplete() {
        return isRefreshComplete;
    }

    public int getSbRowSpacer() {
        return sbRowSpacer;
    }

    public void pullDownToRefreshAction(ActionEvent actionEvent) {
        // Add event code here...        
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("orders");            
            isRefreshComplete=true;
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void initiateDashboard(){
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("orders");   
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.getSearchStatus}", "false");
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.clearSearch}", "true");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public void refreshOrders(ActionEvent ae){
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrders", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrders", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.flushDataChangeEvent();
//            providerChangeSupport.fireProviderRefresh("orders");       
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.getSearchStatus}", "false");
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.clearSearch}", "true");
//            clearSearch=true;
//            getSearchStatus=false;
        } catch (Exception e) {
            e.getMessage();
        }           
    }
    
    public Boolean getRefreshStatus(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return false;
    }
       
    
    public String getAlertCount(){
        String currentTab = (String) AdfmfJavaUtilities.evaluateELExpression("#{pageFlowScope.currentTab}");
        AmxIteratorBinding ib =null;
        int alertCount=0;
        if(currentTab==null){
            currentTab="TOP";
        }
        if(currentTab.equals("TOP")){
            ib= (AmxIteratorBinding) AdfmfJavaUtilities.evaluateELExpression("#{bindings.xxMyOrderDetailsVOIterator}");
        }else{
            ib= (AmxIteratorBinding) AdfmfJavaUtilities.evaluateELExpression("#{bindings.xxMyOrderDetailsVOIterator1}");   
        }
        ib.getIterator().first();
        for(int i=0;i<ib.getIterator().getTotalRowCount();i++){
            GenericType row = (GenericType) ib.getIterator().getCurrentRow();
            if(row.getAttribute("alertFlag").toString().equals("Y")){
                alertCount++;
            }            
            ib.getIterator().next();
        }
                   
        return new Integer(alertCount).toString();
    }
}
