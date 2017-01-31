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
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    
    public GraphicalDB() {
        super();

        statuses.add(new Status("Entered",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.enteredCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.enteredTotal}")));
        statuses.add(new Status("Booked",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.bookedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.bookedTotal}")));
        statuses.add(new Status("In Process",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.processCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.processTotal}")));
        statuses.add(new Status("Shipped",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.shippedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.shippedTotal}")));
        statuses.add(new Status("Delivered",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.deliveredCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.deliveredTotal}")));
        statuses.add(new Status("Returned",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.returnedCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.returnedTotal}")));
        statuses.add(new Status("Cancelled",(Integer) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cancelledCount}"), (Float) AdfmfJavaUtilities.getELValue("#{pageFlowScope.cancelledTotal}")));
    }
    
    public Status[] getAllStatuses() {
            return (Status[]) statuses.toArray(new Status[statuses.size()]);
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
