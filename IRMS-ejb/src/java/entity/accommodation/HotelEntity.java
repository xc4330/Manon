package entity.accommodation;

import java.io.Serializable;
import java.util.Collection;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Hotel")
public class HotelEntity implements Serializable {

    @Id
    private long hotelId;
    private String name;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "hotel")
    private Collection<RoomEntity> rooms = new ArrayList<RoomEntity>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "hotel")
    private Collection<RatePlanEntity> ratePlans = new ArrayList<RatePlanEntity>();
    @OneToMany(cascade = {CascadeType.ALL})
    private Collection<RoomTypeEntity> roomTypes = new ArrayList<RoomTypeEntity>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "hotel")
    private Collection<RoomServiceEntity> roomServices = new ArrayList<RoomServiceEntity>();

    public HotelEntity() {
        setHotelId(System.nanoTime());
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRooms(Collection<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    public void setRatePlans(Collection<RatePlanEntity> ratePlans) {
        this.ratePlans = ratePlans;
    }

    public void setRoomTypes(Collection<RoomTypeEntity> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public long getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<RoomEntity> getRooms() {
        return rooms;
    }

    public Collection<RatePlanEntity> getRatePlans() {
        return ratePlans;
    }

    public Collection<RoomTypeEntity> getRoomTypes() {
        return roomTypes;
    }

    public Collection<RoomServiceEntity> getRoomServices() {
        return roomServices;
    }

    public void setRoomServices(Collection<RoomServiceEntity> roomServices) {
        this.roomServices = roomServices;
    }
    
    

}
