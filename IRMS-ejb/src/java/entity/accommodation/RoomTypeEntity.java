/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation;

//Testing..... This is fucking day
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author lenovo
 */
@Entity
public class RoomTypeEntity implements Serializable {

    @Id
    private Long roomTypeId;
    private String name;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "roomType")
    private Collection<RoomEntity> rooms = new ArrayList<RoomEntity>();
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "ROOMTYPE_ITEM")
    private Collection<RoomItemEntity> roomItems = new ArrayList<RoomItemEntity>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "roomType")
    private Collection<RatePlanEntity> ratePlans = new ArrayList<RatePlanEntity>();

    public RoomTypeEntity() {
        setRoomTypeId(System.nanoTime());
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    public Collection<RoomItemEntity> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(Collection<RoomItemEntity> roomItems) {
        this.roomItems = roomItems;
    }

    public Collection<RatePlanEntity> getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(Collection<RatePlanEntity> ratePlans) {
        this.ratePlans = ratePlans;
    }

    
}
