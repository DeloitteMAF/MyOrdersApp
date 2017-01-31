package com.company.myorders.application;


import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ChartDrillEvent;
import oracle.adfmf.amx.event.SelectionEvent;
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
    String customerName;
    boolean comingFromNotification;
    boolean springBoardStatus = false;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private int detailRowSpacer = 15;
    private int sbRowSpacer = 10;
    private String lineStatus="N";
    private String transLineStatus="N";
    private String transActivityStatus="N";
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

    public void setTransLineStatus(String transLineStatus) {
        String oldTransLineStatus = this.transLineStatus;
        this.transLineStatus = transLineStatus;
        propertyChangeSupport.firePropertyChange("transLineStatus", oldTransLineStatus, transLineStatus);
    }

    public String getTransLineStatus() {
        return transLineStatus;
    }

    public void setTransActivityStatus(String transActivityStatus) {
        String oldTransActivityStatus = this.transActivityStatus;
        this.transActivityStatus = transActivityStatus;
        propertyChangeSupport.firePropertyChange("transActivityStatus", oldTransActivityStatus, transActivityStatus);
    }

    public String getTransActivityStatus() {
        return transActivityStatus;
    }

    public void setSelectedLine(String selectedLine) {
        String oldSelectedLine = this.selectedLine;
        this.selectedLine = selectedLine;
        propertyChangeSupport.firePropertyChange("selectedLine", oldSelectedLine, selectedLine);
    }

    public String getSelectedLine() {
        return selectedLine;
    }

    public void setCustomerName(String customerName) {
        String oldCustomerName = this.customerName;
        this.customerName = customerName;
        propertyChangeSupport.firePropertyChange("customerName", oldCustomerName, customerName);
    }

    public String getCustomerName() {
        return customerName;
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
            if ((String) AdfmfJavaUtilities.getELValue("#{deviceScope.hardware.networkStatus}")!="NotReachable") {
                try {
                    strResponse = restServiceAdapter.send(null);
                    JSONObject jsonObject = new JSONObject(strResponse);
                    JSONObject parent = jsonObject.getJSONObject("P_OUT_MAIL_DATA");
                    JSONArray nodeArray = parent.getJSONArray("P_OUT_MAIL_DATA_ITEM");
                    int size = nodeArray.length();

                    for (int i = 0; i < size; i++) {
                        JSONObject temp = nodeArray.getJSONObject(i);

                        if (temp.getString("RETURN_STATUS") != null)
                            returnMsg = temp.getString("RETURN_STATUS");
                    }
                } catch (Exception e) {
                    strResponse = e.getMessage();
                }
                if (strResponse.contains("success")) {
                    //AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}","URI Submitted: "+strURI+". Received a response: "+ returnMsg);
                    //System.out.println("summary servie:" + "URI Submitted: " + strURI + ". Received a response: " +
                    //                   returnMsg);
                    AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}", returnMsg);
                } else {
                    AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}",
                                                  "URI Submitted: " + strURI + ". Received a response: " + returnMsg +
                                                  ". Please verify your network and try again!");
                }
            }
            else
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.reportReturnMessage}","You are not in network area right now. Please try again later.");
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

    public void switchTransLines(ActionEvent actionEvent) {
        if((String)AdfmfJavaUtilities.getELValue("#{applicationScope.OrdersManagedBean.transLineStatus}")=="Y"){
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.transLineStatus}", "N");
        }
        else
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.transLineStatus}", "Y");
    }

    public void switchTransActivities(ActionEvent actionEvent) {
        if((String)AdfmfJavaUtilities.getELValue("#{applicationScope.OrdersManagedBean.transActivityStatus}")=="Y"){
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.transActivityStatus}", "N");
        }
        else
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.transActivityStatus}", "Y");
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
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fStatus}", "");
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrdersRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("orders");
            getStatusCount();
            isRefreshComplete=true;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void pullDownToRefreshTransAction(ActionEvent actionEvent) {
        // Add event code here...
        try {
//            AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransStatus}", "");
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
            providerChangeSupport.fireProviderRefresh("transactions");
            getTransStatusCount();
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
            getStatusCount();
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.getSearchStatus}", "false");
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.clearSearch}", "true");
        } catch (Exception e) {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.Error}", e.getMessage());
            e.getMessage();
        }
    }

    public void initiateDashboardTrans(){
        try {
         //   AdfmfJavaUtilities.invokeDataControlMethod("TransactionsService", null, "findAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            Thread.sleep(5000);
            AdfmfJavaUtilities.flushDataChangeEvent();
//                      providerChangeSupport.fireProviderRefresh("orders");
            getTransStatusCount();
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.getSearchStatus}", "false");
            AdfmfJavaUtilities.setELValue("#{applicationScope.OrdersManagedBean.clearSearch}", "true");
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
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fStatus}", "");
            AdfmfJavaUtilities.invokeDataControlMethod("AllOrdersService", null, "findAllAllOrders", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.flushDataChangeEvent();
            getStatusCount();
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
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTransStatus}", "");
            AdfmfJavaUtilities.invokeDataControlMethod("AllTransactionsService", null, "findAllAllTransactionsRemote", new ArrayList(), new ArrayList(), new ArrayList());
            AdfmfJavaUtilities.flushDataChangeEvent();
    //            providerChangeSupport.fireProviderRefresh("orders");
            getTransStatusCount();
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

    public void getStatusCount(){
        AmxIteratorBinding ib =null;
        float rowTotal = 0;
        int enteredCount=0;
        float enteredTotal=0;
        int bookedCount=0;
        float bookedTotal=0;
        int processCount=0;
        float processTotal=0;
        int shippedCount=0;
        float shippedTotal=0;
        int deliveredCount=0;
        float deliveredTotal=0;
        int closedCount=0;
        float closedTotal=0;
        int returnedCount=0;
        float returnedTotal=0;
        int cancelledCount=0;
        float cancelledTotal=0;
        int allCount=0;
        float allTotal=0;
        try {
            ib = (AmxIteratorBinding) AdfmfJavaUtilities.getELValue("#{bindings.allOrdersIterator}");
            ib.getIterator().first();
            for (int i = 0; i < ib.getIterator().getTotalRowCount(); i++) {
                GenericType row = (GenericType) ib.getIterator().getCurrentRow();
                rowTotal = Float.parseFloat(row.getAttribute("totalActual").toString().replaceAll(",", ""));
                if (row.getAttribute("flowStatusCode").toString().equals("Entered")) {
                    enteredCount++;
                    enteredTotal = enteredTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Booked")) {
                    bookedCount++;
                    bookedTotal = bookedTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("In Process")) {
                    processCount++;
                    processTotal = processTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Shipped")) {
                    shippedCount++;
                    shippedTotal = shippedTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Delivered")) {
                    deliveredCount++;
                    deliveredTotal = deliveredTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Closed")) {
                    closedCount++;
                    closedTotal = closedTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Returned")) {
                    returnedCount++;
                    returnedTotal = returnedTotal + rowTotal;
                }
                if (row.getAttribute("flowStatusCode").toString().equals("Cancelled")) {
                    cancelledCount++;
                    cancelledTotal = cancelledTotal + rowTotal;
                }
                allCount++;
                allTotal = allTotal + rowTotal;
                customerName = row.getAttribute("customer").toString();
                ib.getIterator().next();
            }
            //AdfmfJavaUtilities.setELValue("#{pageFlowScope.fStatus}", "#");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.enteredCount}", new Integer(enteredCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.enteredTotal}", new Float(enteredTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.bookedCount}", new Integer(bookedCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.bookedTotal}", new Float(bookedTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.processCount}", new Integer(processCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.processTotal}", new Float(processTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.shippedCount}", new Integer(shippedCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.shippedTotal}", new Float(shippedTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.deliveredCount}", new Integer(deliveredCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.deliveredTotal}", new Float(deliveredTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.closedCount}", new Integer(closedCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.closedTotal}", new Float(closedTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.returnedCount}", new Integer(returnedCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.returnedTotal}", new Float(returnedTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cancelledCount}", new Integer(cancelledCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cancelledTotal}", new Float(cancelledTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.allCount}", new Integer(allCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.allTotal}", new Float(allTotal));
        } catch (NumberFormatException nfe) {
            // TODO: Add catch code
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.getCountError}", nfe.getMessage());
            nfe.printStackTrace();
        }
        catch(Exception e){
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.Error}", e.getMessage());
            e.getMessage();
        }
    }

    public void getTransStatusCount(){
        AmxIteratorBinding ib =null;
        float rowTotal = 0;
        int fCount=0;
        float fTotal=0;
        int pCount=0;
        float pTotal=0;
        int uCount=0;
        float uTotal=0;
        int cfCount=0;
        float cfTotal=0;
        int cpCount=0;
        float cpTotal=0;
        int cuCount=0;
        float cuTotal=0;
        int allTransCount=0;
        float allTransTotal=0;
        try {
            ib = (AmxIteratorBinding) AdfmfJavaUtilities.getELValue("#{bindings.allTransactionsIterator}");
            ib.getIterator().first();
            for (int i = 0; i < ib.getIterator().getTotalRowCount(); i++) {
                GenericType row = (GenericType) ib.getIterator().getCurrentRow();
                rowTotal = Float.parseFloat(row.getAttribute("InvoiceAmount").toString().replaceAll(",", ""));
                if (row.getAttribute("trxStatus").toString().equals("F")) {
                    fCount++;
                    fTotal = fTotal + rowTotal;
                }
                if (row.getAttribute("trxStatus").toString().equals("U")) {
                    uCount++;
                    uTotal = uTotal + rowTotal;
                }
                if (row.getAttribute("trxStatus").toString().equals("P")) {
                    pCount++;
                    pTotal = pTotal + rowTotal;
                }
                if (row.getAttribute("trxStatus").toString().equals("CF")) {
                    cfCount++;
                    cfTotal = cfTotal + rowTotal;
                }
                if (row.getAttribute("trxStatus").toString().equals("CU")) {
                    cuCount++;
                    cuTotal = cuTotal + rowTotal;
                }
                if (row.getAttribute("trxStatus").toString().equals("CP")) {
                    cpCount++;
                    cpTotal = cpTotal + rowTotal;
                }
                allTransCount++;
                allTransTotal = allTransTotal + rowTotal;
                ib.getIterator().next();
            }
            //AdfmfJavaUtilities.setELValue("#{pageFlowScope.fStatus}", "#");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fCount}", new Integer(fCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.fTotal}", new Float(fTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.uCount}", new Integer(uCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.uTotal}", new Float(uTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.pCount}", new Integer(pCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.pTotal}", new Float(pTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cfCount}", new Integer(cfCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cfTotal}", new Float(cfTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cuCount}", new Integer(cuCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cuTotal}", new Float(cuTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cpCount}", new Integer(cpCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.cpTotal}", new Float(cpTotal));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.allTransCount}", new Integer(allTransCount));
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.allTransTotal}", new Float(allTransTotal));
        } catch (NumberFormatException nfe) {
            // TODO: Add catch code
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.getCountError}", nfe.getMessage());
            nfe.printStackTrace();
        }
        catch(Exception e){
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.Error}", e.getMessage());
            e.getMessage();
        }
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
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.Error}", e.getMessage());
            e.getMessage();
        }
        //AdfmfJavaUtilities.setELValue("#{pageFlowScope.isFilterApplier}","N");
        return "goToFilteredDashboard";
    }

    public String applyTransGraphFilters() {
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
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.Error}", e.getMessage());
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
