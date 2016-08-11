 CREATE TABLE TRANSACTIONS 
(
      CUSTOMER_TRX_ID NUMERIC  NOT NULL,
      TRX_NUMBER VARCHAR ,
      TRX_DATE VARCHAR ,
      SALES_ORDER VARCHAR ,
      INVOICE_AMOUNT VARCHAR ,
      AMOUNT_DUE VARCHAR ,
      TRX_STATUS VARCHAR,
      DUE_DATE VARCHAR ,
      CLOSED_FLAG VARCHAR ,
      A_RALERT_FLAG VARCHAR ,
    CONSTRAINT TRANSACTIONS_PK PRIMARY KEY(CUSTOMER_TRX_ID)
);
  CREATE TABLE TRANSACTION_DETAILS 
(
      CUSTOMER_TRX_ID NUMERIC  NOT NULL,
      LINE_NUMBER NUMERIC  NOT NULL,
      QUANTITY_INVOICED VARCHAR ,   
      DESCRIPTION VARCHAR ,
      UNIT_SELLING_PRICE VARCHAR ,
      STATUS VARCHAR , 
      AMOUNT VARCHAR ,           
      APPLICATION_TYPE VARCHAR ,
      DUE_DATE VARCHAR ,
      INVOICE_AMOUNT VARCHAR , 
      INVOICE_DUE_AMOUNT VARCHAR ,
      ALERT_FLAG VARCHAR ,
    CONSTRAINT TRANSACTION_DETAILS_PK PRIMARY KEY(CUSTOMER_TRX_ID,LINE_NUMBER)
);
  CREATE TABLE ALL_TRANSACTIONS 
(
      CUSTOMER_TRX_ID NUMERIC  NOT NULL,
      TRX_NUMBER VARCHAR ,
      TRX_DATE VARCHAR ,
      SALES_ORDER VARCHAR ,
      INVOICE_AMOUNT VARCHAR ,
      AMOUNT_DUE VARCHAR , 
      TRX_STATUS VARCHAR, 
      DUE_DATE VARCHAR ,
      CLOSED_FLAG VARCHAR ,
      A_RALERT_FLAG VARCHAR ,
    CONSTRAINT ALL_TRANSACTIONS_PK PRIMARY KEY(CUSTOMER_TRX_ID)
);
  CREATE TABLE ALL_TRANSACTION_DETAILS 
(
      CUSTOMER_TRX_ID NUMERIC  NOT NULL,
      LINE_NUMBER NUMERIC  NOT NULL,   
      QUANTITY_INVOICED VARCHAR ,      
      DESCRIPTION VARCHAR ,
      UNIT_SELLING_PRICE VARCHAR ,   
      STATUS VARCHAR ,
      AMOUNT VARCHAR ,       
      APPLICATION_TYPE VARCHAR ,
      DUE_DATE VARCHAR ,
      INVOICE_AMOUNT VARCHAR ,   
      INVOICE_DUE_AMOUNT VARCHAR , 
      ALERT_FLAG VARCHAR ,
    CONSTRAINT ALL_TRANSACTION_DETAILS_PK PRIMARY KEY(CUSTOMER_TRX_ID,LINE_NUMBER)
);
  CREATE TABLE ORDERS 
(
      ORDER_NUMBER VARCHAR  NOT NULL,
      PARTY_NAME VARCHAR ,
      ACCOUNT_NUMBER VARCHAR ,
      FLOW_STATUS_CODE VARCHAR ,
      ORDERED_DATE VARCHAR ,
      CUST_PO_NUMBER VARCHAR ,
      TOTAL_ORDERED_VALUE VARCHAR ,
      HEADER_ID NUMERIC ,
      CURRENCY_CODE VARCHAR ,
      ORDER_ALERT_FLAG VARCHAR ,
    CONSTRAINT ORDERS_PK PRIMARY KEY(ORDER_NUMBER)
);
  CREATE TABLE ORDER_DETAILS 
(
      HEADER_ID NUMERIC ,
      LINE_ID NUMERIC  NOT NULL,
      LINE_NUMBER VARCHAR ,
      ORDERED_ITEM VARCHAR ,
      DESCRIPTION VARCHAR ,
      LINE_STATUS VARCHAR ,
      ORDERED_QUANTITY NUMERIC ,
      ORDER_QUANTITY_UOM VARCHAR ,
      SHIPPED_QUANTITY NUMERIC ,
      SHIPPING_QUANTITY_UOM VARCHAR ,
      UNIT_SELLING_PRICE VARCHAR ,
      LINE_TOTAL VARCHAR ,
      DELIVERY_NAME VARCHAR ,
      FREIGHT_CODE VARCHAR ,
      ACTUAL_ARRIVAL_DATE VARCHAR ,
      BACKORDER_QUANTITY VARCHAR ,
      ADDRESS VARCHAR ,
      SHIP_TO_CONTACT VARCHAR ,
      ALERT_FLAG VARCHAR ,
      CURRENCY_CODE VARCHAR ,
    CONSTRAINT ORDER_DETAILS_PK PRIMARY KEY(LINE_ID)
);
  CREATE TABLE ALL_ORDERS 
(
      ORDER_NUMBER VARCHAR  NOT NULL,
      PARTY_NAME VARCHAR ,
      ACCOUNT_NUMBER VARCHAR ,
      FLOW_STATUS_CODE VARCHAR ,
      ORDERED_DATE VARCHAR ,
      CUST_PO_NUMBER VARCHAR ,
      TOTAL_ORDERED_VALUE VARCHAR ,
      HEADER_ID NUMERIC ,
      CURRENCY_CODE VARCHAR ,
      ORDER_ALERT_FLAG VARCHAR ,
    CONSTRAINT ALL_ORDERS_PK PRIMARY KEY(ORDER_NUMBER)
);
  CREATE TABLE ALL_ORDER_DETAILS 
(
      HEADER_ID NUMERIC ,
      LINE_ID NUMERIC  NOT NULL,
      LINE_NUMBER VARCHAR ,
      ORDERED_ITEM VARCHAR ,
      DESCRIPTION VARCHAR ,
      LINE_STATUS VARCHAR ,
      ORDERED_QUANTITY NUMERIC ,
      ORDER_QUANTITY_UOM VARCHAR ,
      SHIPPED_QUANTITY NUMERIC ,
      SHIPPING_QUANTITY_UOM VARCHAR ,
      UNIT_SELLING_PRICE VARCHAR ,
      LINE_TOTAL VARCHAR ,
      DELIVERY_NAME VARCHAR ,
      FREIGHT_CODE VARCHAR ,
      ACTUAL_ARRIVAL_DATE VARCHAR ,
      BACKORDER_QUANTITY VARCHAR ,
      ADDRESS VARCHAR ,
      SHIP_TO_CONTACT VARCHAR ,
      ALERT_FLAG VARCHAR ,
      CURRENCY_CODE VARCHAR ,
    CONSTRAINT ALL_ORDER_DETAILS_PK PRIMARY KEY(LINE_ID)
);
  CREATE TABLE RESULT 
(
      LOCATION_CODE VARCHAR  NOT NULL,
      LOCATION_FULL_NAME VARCHAR ,
    CONSTRAINT RESULT_PK PRIMARY KEY(LOCATION_CODE)
);
 

CREATE TABLE DATA_SYNCH_ACTIONS 
(
      ID NUMERIC NOT NULL,
      SERVICE_CLASS_NAME VARCHAR NOT NULL,
      ENTITY_CLASS_NAME VARCHAR NOT NULL,
      JSON_PAYLOAD VARCHAR ,
      ACTION VARCHAR NOT NULL,
      DATE_CREATED DATE NOT NULL,
      DATE_LAST_SYNCH DATE NOT NULL,
      LAST_SYNCH_ERROR VARCHAR,
      CUSTOM_METHOD_NAME VARCHAR,
    CONSTRAINT DSA_PK PRIMARY KEY(SERVICE_CLASS_NAME ,ID)
);

CREATE TABLE WEB_SERVICE_CALL 
(
      ID NUMERIC  NOT NULL,
      CONNECTION VARCHAR ,
      REQUEST VARCHAR ,
      METHOD VARCHAR ,
      REQUEST_HEADERS VARCHAR ,
      DURATION NUMERIC ,
      REQUEST_PAYLOAD VARCHAR ,
      RESPONSE_PAYLOAD VARCHAR ,
      ERROR_MESSAGE VARCHAR ,
      TIMESTAMP DATE ,
    CONSTRAINT WEB_SERVICE_CALL_PK PRIMARY KEY(ID)
);
