package com.company.myorders.application;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxIteratorBinding;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.exception.AdfInvocationException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.util.GenericType;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;


public class OrdersManagedBean {
    boolean getSearchStatus = false;
    boolean clearSearch = true;
    String currentFeature;
    boolean comingFromNotification;
    boolean springBoardStatus = false;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private int detailRowSpacer = 15;
    private int sbRowSpacer = 10;
    private String lineStatus="N";
    private String selectedLine;
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

    public void setComingFromNotification(boolean comingFromNotification) {
        boolean oldComingFromNotification = this.comingFromNotification;
        this.comingFromNotification = comingFromNotification;
        propertyChangeSupport.firePropertyChange("comingFromNotification", oldComingFromNotification,
                                                 comingFromNotification);
    }

    public boolean isComingFromNotification() {
        return comingFromNotification;
    }

    public void setLineStatus(String lineStatus) {
        String oldLineStatus = this.lineStatus;
        this.lineStatus = lineStatus;
        propertyChangeSupport.firePropertyChange("lineStatus", oldLineStatus, lineStatus);
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setSelectedLine(String selectedLine) {
        String oldSelectedLine = this.selectedLine;
        this.selectedLine = selectedLine;
        propertyChangeSupport.firePropertyChange("selectedLine", oldSelectedLine, selectedLine);
    }

    public String getSelectedLine() {
        return selectedLine;
    }
    
    public void printReportClicked(ActionEvent actionEvent) {
        try {
            RestServiceAdapter restServiceAdapter = RestServiceAdapterFactory.newFactory().createRestServiceAdapter();
            restServiceAdapter.clearRequestProperties();
            restServiceAdapter.setConnectionName("OSBService");
            restServiceAdapter.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);
            restServiceAdapter.setRetryLimit(0);
            String strUser = (String) AdfmfJavaUtilities.getELValue("#{securityContext.userName}");
            String strReport = (String) AdfmfJavaUtilities.getELValue("#{pageFlowScope.reportType}");
            String strEntity = (String) AdfmfJavaUtilities.getELValue("#{pageFlowScope.entityType}");
            String strId = (String) AdfmfJavaUtilities.getELValue("#{pageFlowScope.entityId}");
            String strURI = "/MyOrdersPrintReports/MyOrderPrintReportsRestService/";
            strURI = strURI + strUser + "/";
            strURI = strURI + strReport + "/";
            strURI = strURI + strEntity + "/";
            strURI = strURI + strId;
            restServiceAdapter.setRequestURI(strURI);
            String strResponse = "";
            String returnMsg = null;
            try {
                strResponse = restServiceAdapter.send(null);
                JSONObject jsonObject = new JSONObject(strResponse);
                JSONObject parent = jsonObject.getJSONObject("P_OUT_MAIL_DATA");
                JSONArray nodeArray = parent.getJSONArray("P_OUT_MAIL_DATA_ITEM");            int size = nodeArray.length();
                
                for (int i = 0; i < size; i++) {
                    JSONObject temp = nodeArray.getJSONObject(i);

                    if (temp.getString("RETURN_STATUS") != null)
                        returnMsg = temp.getString("RETURN_STATUS");
                }
            } catch (Exception e) {
                strResponse = e.getMessage();
            }
            if(strResponse.contains("success")) {
                //AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}","URI Submitted: "+strURI+". Received a response: "+ returnMsg);
                System.out.println("summary servie:" + "URI Submitted: "+strURI+". Received a response: "+ returnMsg);
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}",returnMsg);
            }
            else{
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}","URI Submitted: "+strURI+". Received a response: "+ returnMsg+". Please verify your network and try again!");
            }                
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            String error = e.getMessage();
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}","Error in submitting request" + error);
        }
//        AdfmfJavaUtilities.
//        setStrComments("");
//        setStrContractStsMsg(strResponse);
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
    
    public void switchOrderLines(ActionEvent actionEvent) {
        if((String)AdfmfJavaUtilities.getELValue("#{applicationScope.OrdersManagedBean.lineStatus}")=="Y"){
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.lineStatus}", "N");
        }
        else
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.lineStatus}", "Y");
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
    


    public void pullDownToRefreshAction(ActionEvent actionEvent) {
        // Add event code here...        
        try {
    //         AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("orders");            
            isRefreshComplete=true;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void pullDownToRefreshTransAction(ActionEvent actionEvent) {
        // Add event code here...        
        try {
//            AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("transactions");            
            isRefreshComplete=true;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void pullDownToRefreshNotification(ActionEvent actionEvent) {
        // Add event code here...        
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("NotificationsService", null, "findAllNotificationsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("notifications");            
            isRefreshComplete=true;
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void initiateDashboard(){
        try {
     //       AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
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
    
    public void initiateDashboardTrans(){
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
//            providerChangeSupport.fireProviderRefresh("transactions"); 
            providerChangeSupport.fireProviderRefresh("allTransactions");   
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void initiateNotifications(){
        try {
            AdfmfJavaUtilities.invokeDataControlMethod("NotificationsService", null, "findAllNotificationsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("notifications");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void refreshOrders(ActionEvent ae){
        try {
       //     AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findAllOrders", new ArrayList(), new ArrayList(), new ArrayList());
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
    
    public void refreshTrans(ActionEvent ae){
        try {
//            AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.flushDataChangeEvent();
    //            providerChangeSupport.fireProviderRefresh("orders");
//            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.getSearchStatus}", "false");
//            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.clearSearch}", "true");
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
       
    
    public void getAlertCount(ActionEvent ae){
    //        String currentTab = (String) AdfmfJavaUtilities.getELValue("#{pageFlowScope.currentTab}");
        AmxIteratorBinding ib =null;
        int alertCount=0;
        int lineCount=0;
    //        if(currentTab==null){
    //            currentTab="TOP";
    //        }
    //        if(currentTab.equals("TOP")){
    //            ib= (AmxIteratorBinding) AdfmfJavaUtilities.getELValue("#{bindings.xxMyOrderDetailsVOIterator}");
    //        }else{
            ib= (AmxIteratorBinding) AdfmfJavaUtilities.getELValue("#{bindings.xxMyOrderDetailsVOIterator1}");   
    //        }
        ib.getIterator().first();
        for(int i=0;i<ib.getIterator().getTotalRowCount();i++){
            GenericType row = (GenericType) ib.getIterator().getCurrentRow();
            if(row.getAttribute("alertFlag").toString().equals("Y")){
                alertCount++;
            }
            lineCount++;
            ib.getIterator().next();
        }
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.alertCount}", new Integer(alertCount).toString());
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.lineCount}", new Integer(lineCount).toString());
        AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.lineStatus}", "N");     
    }
    
    public void callButtonActionJS(String btn) {
        String featureID = AdfmfJavaUtilities.getFeatureId();
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "showPopup", new Object[] { btn });
    }

    
    public void onKeyDownSearch(String searchStr){
        try{
        System.out.println("test keydown search: " +searchStr);
        List pnames = new ArrayList();
        List params = new ArrayList();
        List ptypes = new ArrayList();
        pnames.add("searchValue");
        params.add(searchStr);
        ptypes.add(String.class);
      
     //   AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findOrders", pnames, params, ptypes);
        AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllOrders", pnames, params, ptypes);
        
    //       callButtonActionJS("cl4");
            Integer i =
                (Integer) AdfmfJavaUtilities.getELValue("#{bindings.allOrdersIterator.iterator.totalRowCount}");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.OrdersCount}",i);
    //            Integer j =
    //                (Integer) AdfmfJavaUtilities.getELValue("#{bindings.ordersIterator.iterator.totalRowCount}");
    //            AdfmfJavaUtilities.setELValue("#{pageFlowScope.topOrdersCount}",j);
    //        String featureID = AdfmfJavaUtilities.getFeatureId();
    //        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(featureID, "setFocusOnInput", new Object[] {});
        }
        catch(Exception e){
            e.getMessage();
        }
        
    }

    
    public void onKeyDownTransSearch(String searchStr){
        try{
        System.out.println("test keydown search: " +searchStr);
        List pnames = new ArrayList();
        List params = new ArrayList();
        List ptypes = new ArrayList();
        pnames.add("searchValue");
        params.add(searchStr);
        ptypes.add(String.class);
      
//        AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findTransactions", pnames, params, ptypes);
        AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllTransactions", pnames, params, ptypes);
        
        }
        catch(Exception e){
            e.getMessage();
        }
        
    }

    public String applyGraphFilters() {
        // Add event code here...
        List pnames = new ArrayList();
        List params = new ArrayList();
        List ptypes = new ArrayList();
        pnames.add("searchValue");
        params.add("");
        ptypes.add(String.class);
        try {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterApplier}","Y");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.currentTab}","ALL");
    //           AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findOrders", pnames, params, ptypes);
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllOrders", pnames, params, ptypes);
        } catch (AdfInvocationException e) {
            e.getMessage();
        }
        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterApplier}","N");
        return "goToFilteredDashboard";
    }

    public String applyFilters() {
        // Add event code here...
        List pnames = new ArrayList();
        List params = new ArrayList();
        List ptypes = new ArrayList();
        pnames.add("searchValue");
        params.add("");
        ptypes.add(String.class);
        try {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterApplier}","Y");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.currentTab}","ALL");
    //           AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findOrders", pnames, params, ptypes);
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllOrders", pnames, params, ptypes);
        } catch (AdfInvocationException e) {
            e.getMessage();
        }
        return "back";
    }

    public String createFilter() {
        // Add event code here...
        if(AdfmfJavaUtilities.getELValue("#{pageFlowScope.isFilterApplier}")=="Y"){
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fOrderNo}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fOrderValue}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fPO}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fStatus}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fAlert}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterApplier}","N");
            try {
                List pnames = new ArrayList();
                List params = new ArrayList();
                List ptypes = new ArrayList();
                pnames.add("searchValue");
                params.add("");
                ptypes.add(String.class);
    //               AdfmfJavaUtilities.invokeDataControlMethod("OrdersService", null, "findOrders", pnames, params, ptypes);
                AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllOrders", pnames, params, ptypes);
            } catch (AdfInvocationException e) {
                e.getMessage();
            }
            return null;
        }else{
            return "search"; 
        }
        
    }

    public String applyFiltersTrans() {
        // Add event code here...
        List pnames = new ArrayList();
        List params = new ArrayList();
        List ptypes = new ArrayList();
        pnames.add("searchValue");
        params.add("");
        ptypes.add(String.class);
        try {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterAppliedTrans}","Y");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.currentTab}","ALL");
//            AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findTransactions", pnames, params, ptypes);
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllTransactions", pnames, params, ptypes);
        } catch (AdfInvocationException e) {
            e.getMessage();
        }
        return "back";
    }

    public String createFilterTrans() {
        // Add event code here...
        if(AdfmfJavaUtilities.getELValue("#{pageFlowScope.isFilterAppliedTrans}")=="Y"){
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fOrderNo}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransValue}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransNo}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransStatus}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransAlert}",null);
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterAppliedTrans}","N");
            try {
                List pnames = new ArrayList();
                List params = new ArrayList();
                List ptypes = new ArrayList();
                pnames.add("searchValue");
                params.add("");
                ptypes.add(String.class);
 //               AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findTransactions", pnames, params, ptypes);
                AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllTransactions", pnames, params, ptypes);
            } catch (AdfInvocationException e) {
                e.getMessage();
            }
            return null;
        }else{
            return "search"; 
        }
        
    }

}
