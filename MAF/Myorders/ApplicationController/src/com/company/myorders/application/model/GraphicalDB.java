package com.company.myorders.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.internal.AdfmfContainerUtilitiesInternal;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class GraphicalDB {
    protected List statuses=new ArrayList();
    protected List statusesTrans=new ArrayList();
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    
    public GraphicalDB() {
        super();

        statuses.add(new Status(1,"Entered Orders","Entered",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.enteredCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.enteredTotal}")));
        statuses.add(new Status(2,"Booked Orders","Booked",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.bookedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.bookedTotal}")));
        statuses.add(new Status(3,"Orders In Process","In Process",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.processCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.processTotal}")));
        statuses.add(new Status(4,"Shipped","Shipped",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.shippedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.shippedTotal}")));
        statuses.add(new Status(5,"Delivered Orders","Delivered",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.deliveredCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.deliveredTotal}")));
        statuses.add(new Status(6,"Returned Orders","Returned",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.returnedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.returnedTotal}")));
        statuses.add(new Status(7,"Cancelled Orders","Cancelled",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cancelledCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cancelledTotal}")));
        statuses.add(new Status(8,"Closed Orders","Closed",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.closedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.closedTotal}")));

        statusesTrans.add(new Status(1,"Fully Paid Transactions","F",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.fCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.fTotal}")));
        statusesTrans.add(new Status(2,"Partially Paid Transactions","P",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.pCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.pTotal}")));
        statusesTrans.add(new Status(3,"Unpaid Transactions","U",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.uCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.uTotal}")));
        statusesTrans.add(new Status(4,"Fully Applied Credit Memos","CF",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cfCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cfTotal}")));
        statusesTrans.add(new Status(5,"Partially Applied Credit Memos","CP",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cpCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cpTotal}")));
        statusesTrans.add(new Status(6,"Unapplied Credit Memos","CU",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cuCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cuTotal}")));
    }
    
    public Status[] getAllStatuses() {
            return (Status[]) statuses.toArray(new Status[statuses.size()]);
        }

    public Status[] getAllStatusesTrans() {
            return (Status[]) statusesTrans.toArray(new Status[statusesTrans.size()]);
        }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this.propertyChangeSupport;
        this.propertyChangeSupport = propertyChangeSupport;
        propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                 propertyChangeSupport);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}
