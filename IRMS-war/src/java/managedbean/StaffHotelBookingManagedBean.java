package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.common.CustomerEntity;
import javax.ejb.EJB;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import session.common.MemberSessionBeanLocal;
import session.accommodation.RoomReservationManagerBeanLocal;
import entity.accommodation.helper.HotelRoomHelper;
/**
 *
 * @author apple
 */
@ManagedBean(name="staffHotelBookingManagedBean")
@RequestScoped
public class StaffHotelBookingManagedBean {

    /**
     * Creates a new instance of StaffHotelBookingManagedBean
     */
    public StaffHotelBookingManagedBean() {
    }
    private Date arrivalDate;
    private Date departureDate;
    private int roomNum;
    private int adultNum;
    private int childrenNum;
    ArrayList<HotelRoomHelper> list;
    @EJB
    private RoomReservationManagerBeanLocal roomReservationManagerBeanLocal;

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getAdultNum() {
        return adultNum;
    }

    public void setAdultNum(int adultNum) {
        this.adultNum = adultNum;
    }

    public int getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(int childrenNum) {
        this.childrenNum = childrenNum;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }
    
    
    public String onFlowProcess(FlowEvent event) {
	
			return event.getNewStep();
	
	}
    public String searchAvailableRooms(FlowEvent event){
        System.out.println("87 StaffHotelBookingManagedBean "+roomNum);
        System.out.println("88 StaffHotelBookingManagedBean  Current wizard step:" + event.getOldStep());
        System.out.println("89 StaffHotelBookingManagedBean  Next step: " + event.getNewStep()); 
        if(event.getOldStep().equals("tab1")){
            list=(ArrayList<HotelRoomHelper>)roomReservationManagerBeanLocal.searchRoom(arrivalDate, arrivalDate);
        }
        return event.getNewStep();
    }
}
