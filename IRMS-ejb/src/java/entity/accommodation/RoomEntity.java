package entity.accommodation;

import entity.common.CustomerEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "Room")
public class RoomEntity implements Serializable {

    @Id
    private long RoomId;
    private int roomNumber;
    private boolean smoking;
    private boolean active = true;
    @ManyToOne
    private HotelEntity hotel = new HotelEntity();
    @ManyToOne
    private RoomTypeEntity roomType=new RoomTypeEntity();
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name = "ROOM_ROOMRESERVATION")
    private Collection<RoomReservationEntity> reservations = new ArrayList<RoomReservationEntity>();
    @ManyToOne
    private CustomerEntity customer=new CustomerEntity();
    public RoomEntity() {
        setRoomId(System.nanoTime());
    }

    public long getRoomId() {
        return RoomId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
    

    public boolean isSmoking() {
        return smoking;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public Collection<RoomReservationEntity> getReservations() {
        return reservations;
    }

    public void setRoomId(long RoomId) {
        this.RoomId = RoomId;
    }


    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }

    public void setReservations(Collection<RoomReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    

    
}
