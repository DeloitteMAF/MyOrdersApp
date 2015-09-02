package com.company.myorders.mobile;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class Settings {
    public Settings() {
    }

    public void locationVC(ValueChangeEvent valueChangeEvent) {
        
    }
    public String getCurrentFeature(){
        return AdfmfJavaUtilities.getFeatureId();
    }
}
