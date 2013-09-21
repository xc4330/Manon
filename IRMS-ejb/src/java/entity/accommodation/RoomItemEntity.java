package entity.accommodation;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "RoomItem")
public class RoomItemEntity implements Serializable {

    @Id
    private long RoomItemId;
    private String name;
    private double price;
    private String description;

    public RoomItemEntity() {
        setRoomItemId(System.nanoTime());
    }

    public long getRoomItemId() {
        return RoomItemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setRoomItemId(long RoomItemId) {
        this.RoomItemId = RoomItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}