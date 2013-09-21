package entity.accommodation;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "RatePlan")
public class RatePlanEntity implements Serializable {

    @Id
    private long ratePlanId;
    private double rate;
    private String description;
    @ManyToOne
    private RoomTypeEntity roomType;
    @ManyToOne
    private HotelEntity hotel;

    public RatePlanEntity() {
        setRatePlanId(System.nanoTime());
    }

    public long getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(long ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

  
}
