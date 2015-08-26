package com.company.myorders.mobile.model.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class OrdersUtilityBean {
    public OrdersUtilityBean() {
        super();
    }
    public String toDateTime(String value){
        SimpleDateFormat intialFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
        String newDate = null;
        try {
            Date date = intialFormat.parse(value);
            newDate = newFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
