/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import entity.common.CustomerEntity;
import java.util.Date;
import javax.persistence.Temporal;

/**
 *
 * @author sunjunfan
 */
@Entity
public class RoomReservationEntity implements Serializable {

    @Id
    private Long roomReservId;
    private String type;
    private String hotel;
    @ManyToOne
    private CustomerEntity customer = new CustomerEntity();
    @ManyToMany
    private Collection<RoomEntity> rooms = new ArrayList<RoomEntity>();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkinDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkoutDate;

    public RoomReservationEntity(){
        setRoomReservId(System.nanoTime());
    }
    public Long getRoomReservId() {
        return roomReservId;
    }

    public String getType() {
        return type;
    }

    public String getHotel() {
        return hotel;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public Collection<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRoomReservId(Long roomReservId) {
        this.roomReservId = roomReservId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public void setRooms(Collection<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    
}
