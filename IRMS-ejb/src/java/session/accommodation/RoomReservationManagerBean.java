/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.accommodation;

import entity.accommodation.HotelEntity;
import entity.accommodation.RatePlanEntity;
import entity.accommodation.RoomEntity;
import entity.accommodation.RoomItemEntity;
import entity.accommodation.RoomReservationEntity;
import entity.accommodation.RoomServiceEntity;
import entity.common.helper.CustomerHelper;
import entity.common.CustomerEntity;
import java.util.ArrayList;
import javax.ejb.Stateless;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entity.accommodation.helper.HotelRoomHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nirvana
 */
@Stateless
public class RoomReservationManagerBean implements RoomReservationManagerBeanLocal{
 
    @PersistenceContext
    EntityManager em;
    private Date checkinDate;
    private Date checkoutDate;
    Collection<RoomEntity> availableRooms = new ArrayList<RoomEntity>();
    Collection<RoomEntity> selectedRooms = new ArrayList<RoomEntity>(); //this is the room that are added to the cart

    public RoomReservationManagerBean() {
    }

    @Override
    public ArrayList searchRoom(Date checkinDate, Date checkoutDate) {
        //search all available rooms in all hotels based on checkin checkout date
        ArrayList stateList = new ArrayList();
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;

        Query q1 = em.createQuery("SELECT a FROM Hotel a");
        for (Object o1 : q1.getResultList()) {
            HotelEntity a1 = (HotelEntity) o1;
            System.out.println("a1 name is "+a1.getName());
            Collection<RoomEntity> temp1 = new ArrayList<RoomEntity>();
            temp1 = a1.getRooms();
            for (Object o2 : temp1) {
                RoomEntity a2 = (RoomEntity) o2;
                System.out.println("a2 name is "+a2.getRoomId());
                Collection<RoomReservationEntity> temp2 = new ArrayList<RoomReservationEntity>();
                 temp2 = a2.getReservations();
                 System.out.println("room reservation manager bean 64");
                 if(temp2.isEmpty()){
                     availableRooms.add(a2);
                     System.out.println("room reservation manager bean 67");
                 }else{
                     System.out.println("room reservation manager bean 69");
                int counter = 0;
                for (Object o3 : temp2) {
                    RoomReservationEntity a3 = (RoomReservationEntity) o3;
                    System.out.println("room reservation managerbean 67 a3 type is "+a3.getType());
                  
                    if (checkoutDate.before(a3.getCheckinDate()) || checkinDate.after(a3.getCheckoutDate())) {
                        counter++;
                    }
                    if (counter == temp2.size()) {
                        availableRooms.add(a2);
                    }
                  
                }
            }
                 System.out.println("room reservation manager bean 84");
            }
        }

        for (Object o4 : availableRooms) {
            RoomEntity r = (RoomEntity) o4;
           System.out.println("room reservation managerbean 82 r id is "+r.getRoomId());
            double rate = 0;
            try {
                rate = this.checkRate(r);
            } catch (ParseException ex) {
                Logger.getLogger(RoomReservationManagerBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            Collection<String> roomItems = new ArrayList();
            Collection<RoomItemEntity> ris =new ArrayList<RoomItemEntity>();
                    ris= r.getRoomType().getRoomItems();
            for (Object o5 : ris) {
                RoomItemEntity ri = (RoomItemEntity) o5;
                roomItems.add(ri.getName());
            }

            Collection<String> roomServices = new ArrayList<String>();
            Collection<RoomServiceEntity> rss =new ArrayList<RoomServiceEntity>();
                    rss= r.getHotel().getRoomServices();
            for (Object o6 : rss) {
                RoomServiceEntity rs = (RoomServiceEntity) o6;
                roomServices.add(rs.getName());
            }

            HotelRoomHelper hrState = new HotelRoomHelper(
                    r.getHotel().getHotelId(),
                    r.getRoomId(),
                    r.getHotel().getName(),
                    r.getRoomType().getName(),
                    rate,
                    r.getHotel().getDescription(),
                    r.getRoomType().getDescription(),
                    roomItems,
                    roomServices);

            stateList.add(hrState);
        }

        return stateList;
    }

    @Override
    public double checkRate(RoomEntity r) throws ParseException {
        double defaultRate = 0;
        double result = 0;
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(checkinDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(checkoutDate);
        int days = this.computeDate(cal1, cal2);

        Calendar temp = Calendar.getInstance();
        temp.setTime(checkinDate);

        RoomEntity room = em.find(RoomEntity.class, r.getRoomId());
        Collection<RatePlanEntity> plans=new ArrayList<RatePlanEntity>();
                plans =room.getRoomType().getRatePlans();
        for (Object o : plans) {
            RatePlanEntity rateplanEntity = (RatePlanEntity) o;
            if (rateplanEntity.getDescription().equals("DEFAULT")) {
                defaultRate = rateplanEntity.getRate();
            }
        }

        //every room type WILL have a default rate.
        //next we check for special cases.

        for (Object o : plans) {
            RatePlanEntity rateplanEntity = (RatePlanEntity) o;
            String description = rateplanEntity.getDescription();
            if (description.contains("MONTH")) {      //e.g. MONTH11
                double amount = 0;
                for (int i = 0; i < days; i++) {
                    int month = temp.get(Calendar.MONTH) + 1;   //month starts with 0
                    if (month == Integer.parseInt(description.substring(5))) {
                        amount += rateplanEntity.getRate();
                    } else {
                        amount += defaultRate;
                    }
                    temp.add(Calendar.DAY_OF_MONTH, 1);
                }
                result = amount / days; //provide a average rate
            } else if (description.contains("DATE_ON")) { //e.g. DATE_ON20130817
                double amount = 0;
                for (int i = 0; i < days; i++) {
                    int month = temp.get(Calendar.MONTH) + 1;
                    int date = temp.get(Calendar.DATE);   //date starts with 1
                    int year = temp.get(Calendar.YEAR);
                    if (year == Integer.parseInt(description.substring(7, 10))
                            && month == Integer.parseInt(description.substring(11, 12))
                            && date == Integer.parseInt(description.substring(13, 14))) {
                        amount = amount + rateplanEntity.getRate();
                    } else {
                        amount = amount + defaultRate;
                    }
                    temp.add(Calendar.DAY_OF_MONTH, 1);
                }
                result = amount / days; //provide a average rate

            } else if (description.contains("DATE_FROM")) {  //e.g. DATE_FROM2013081720130925
                double amount = 0;
                Calendar date1 = Calendar.getInstance();
                Calendar date2 = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                date1.setTime(sdf.parse(description.substring(9, 16)));
                date1.setTime(sdf.parse(description.substring(17, 24)));

                for (int i = 0; i < days; i++) {
                    if (temp.after(date1) && temp.before(date2)) {
                        amount = amount + rateplanEntity.getRate();
                    } else {
                        amount += defaultRate;
                    }
                    temp.add(Calendar.DAY_OF_MONTH, 1);
                }

                result = amount / days; //provide a average rate

            } else if (description.contains("DAYOFWEEK")) {  //e.g. DAYOFWEEK5
                double amount = 0;
                for (int i = 0; i < days; i++) {
                    int dayOfWeek = temp.get(Calendar.DAY_OF_WEEK) - 1;//in java, the week start on sunday with value 1
                    if (dayOfWeek == Integer.parseInt(description.substring(9))) {
                        amount += rateplanEntity.getRate();
                    } else {
                        amount += defaultRate;
                    }
                    temp.add(Calendar.DAY_OF_MONTH, 1);
                }
                result = amount / days; //provide a average rate
            }
        }
        return result;
    }

    @Override
    public int computeDate(Calendar date1, Calendar date2) {
        Calendar temp = (Calendar) date1.clone();
        int days = 0;
        while (temp.before(date2)) {
            temp.add(Calendar.DAY_OF_MONTH, 1);
            days++;
        }
        return days;
    }

    @Override
    public void blockRoom(String hotel, String roomType, int number) {
        int counter = 0;
        for (Object o : availableRooms) {
            if (counter >= number) {
                break;
            }
            RoomEntity room = (RoomEntity) o;
            if (room.getHotel().getName().equals(hotel)
                    && room.getRoomType().getName().equals(roomType)) {  //Accroding to Yaowenchi, the arraylist should be sorted already, so dont worry
                room.setActive(false);
                selectedRooms.add(room);
                counter++;
            }
        }
    }

    @Override
    public void unblockRoom() {
        //not done yet
    }

    @Override
    public void memberCreateReservation(String email) {

        Query q = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email");
        q.setParameter("email", email);
        CustomerEntity member = (CustomerEntity) q.getSingleResult();

        for (Object o : selectedRooms) {
            RoomEntity r = (RoomEntity) o;
            RoomReservationEntity rr = new RoomReservationEntity();
            rr.setHotel(r.getHotel().getName());
            rr.setCheckinDate(checkinDate);
            rr.setCheckoutDate(checkoutDate);
            rr.setCustomer(member);
            rr.setType(r.getRoomType().getName());

            r.getReservations().add(rr);

            member.getReservations().add(rr);

            em.persist(rr);
            em.persist(r);
            em.persist(member);
        }

    }

    @Override
    public void nonMemberCreateReservation(CustomerHelper ch) {

        CustomerEntity customer = new CustomerEntity();
        customer.setEmail(ch.getEmail());
        customer.setFirstName(ch.getFirstName());
        customer.setLastName(ch.getLastName());
        customer.setPassport(ch.getPassport());

        for (Object o : selectedRooms) {
            RoomEntity r = (RoomEntity) o;
            RoomReservationEntity rr = new RoomReservationEntity();
            rr.setHotel(r.getHotel().getName());
            rr.setCheckinDate(checkinDate);
            rr.setCheckoutDate(checkoutDate);
            rr.setCustomer(customer);
            rr.setType(r.getRoomType().getName());

            r.getReservations().add(rr);

            customer.getReservations().add(rr);

            em.persist(rr);
            em.persist(r);
            em.persist(customer);
        }
    }
}