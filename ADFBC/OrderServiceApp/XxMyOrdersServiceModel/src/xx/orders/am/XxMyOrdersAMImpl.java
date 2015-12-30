package xx.orders.am;

import java.util.ArrayList;
import java.util.List;

import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

import xx.orders.view.XxMyLocationsVORowImpl;
import xx.orders.view.XxMyOrdersVORowImpl;
import xx.orders.view.common.XxMyOrdersVOSDOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 10 08:28:06 IST 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxMyOrdersAMImpl extends ApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XxMyOrdersAMImpl() {
    }

    /**
     * Container's getter for XxMyOrdersVO.
     * @return XxMyOrdersVO
     */
    public ViewObjectImpl getXxMyOrdersVO() {
        return (ViewObjectImpl) findViewObject("XxMyOrdersVO");
    }
    
    public List<XxMyOrdersVORowImpl> getRequestedOrders(Long custAccountId, Integer noOfDays, Integer noOfRows, String location,String orderBy,String fetchClosedOrders) {
        ViewObjectImpl myOrdersVO= null;
            myOrdersVO=(ViewObjectImpl)getXxMyOrdersVO();
        /*if("date".equals(orderBy)){
            myOrdersVO=(ViewObjectImpl)getXxMyOrdersDateSortedVO1();
            myOrdersVO.setOrderByClause("ordered_date");
        }
        else {
            //myOrdersVO=(ViewObjectImpl)getXxMyOrdersVO();
            myOrdersVO.setOrderByClause("total_ordered_value");
        }*/
            switch(orderBy) {
            case "date desc":
                myOrdersVO.setOrderByClause("ordered_date desc");
                break;
            case "date":
                myOrdersVO.setOrderByClause("ordered_date");
                break;
            case "amount desc":
                myOrdersVO.setOrderByClause("total_ordered_value desc");
                break;
            case "amount":
                myOrdersVO.setOrderByClause("total_ordered_value");
            }
        myOrdersVO.applyViewCriteria(null);
        myOrdersVO.setNamedWhereClauseParam("bindCustAccountId", custAccountId);
        myOrdersVO.setNamedWhereClauseParam("bindNoOfDays", noOfDays);
        //myOrdersVO.setNamedWhereClauseParam("bindNoOfRows", NoOfRows);
        myOrdersVO.setNamedWhereClauseParam("bindLocation", location);
        System.out.println("now setting closedorderstatus"+fetchClosedOrders);
        if("No".equals(fetchClosedOrders)) {
            myOrdersVO.setApplyViewCriteriaName("statusCriteria");
        }
        System.out.println("now setting orderby"+orderBy);
        System.out.println("now setting noOfRows"+noOfRows);
        myOrdersVO.setMaxFetchSize(noOfRows);
        myOrdersVO.executeQuery();
        ArrayList<XxMyOrdersVORowImpl> myOrderList=new ArrayList<XxMyOrdersVORowImpl>();
        while(myOrdersVO.hasNext()) {
            myOrderList.add((XxMyOrdersVORowImpl)myOrdersVO.next());
        }
        return myOrderList;
    }
    
    public List<XxMyLocationsVORowImpl> getCustomerLocations(Long custAccountId) {
        ViewObjectImpl myLocationsVO= (ViewObjectImpl)getXxMyLocationsVO();
        myLocationsVO.setNamedWhereClauseParam("bindCustAccountId", custAccountId);
        myLocationsVO.executeQuery();
        ArrayList<XxMyLocationsVORowImpl> myLocationsList=new ArrayList<XxMyLocationsVORowImpl>();
        while(myLocationsVO.hasNext()) {
            myLocationsList.add((XxMyLocationsVORowImpl)myLocationsVO.next());
        }
        return myLocationsList;
    }


    /**
     * Container's getter for XxMyLocationsVO.
     * @return XxMyLocationsVO
     */
    public ViewObjectImpl getXxMyLocationsVO() {
        return (ViewObjectImpl) findViewObject("XxMyLocationsVO");
    }

    /**
     * Container's getter for XxMyOrdersVO1.
     * @return XxMyOrdersVO1
     */
    public ViewObjectImpl getXxMyOrdersVO1() {
        return (ViewObjectImpl) findViewObject("XxMyOrdersVO1");
    }

    /**
     * Container's getter for XxMyOrderDetailsVO1.
     * @return XxMyOrderDetailsVO1
     */
    public ViewObjectImpl getXxMyOrderDetailsVO1() {
        return (ViewObjectImpl) findViewObject("XxMyOrderDetailsVO1");
    }

    /**
     * Container's getter for XxMyOrdersVOToXxMyOrderDetailsVO.
     * @return XxMyOrdersVOToXxMyOrderDetailsVO
     */
    public ViewLinkImpl getXxMyOrdersVOToXxMyOrderDetailsVO() {
        return (ViewLinkImpl) findViewLink("XxMyOrdersVOToXxMyOrderDetailsVO");
    }
}

