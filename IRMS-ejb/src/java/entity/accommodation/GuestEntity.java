/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author nirvana
 */
@Entity
public class GuestEntity implements Serializable {

    @Id
    private Long guestId;
    private String passport;
    private String name;
    @ManyToOne
    private RoomEntity room = new RoomEntity();

    public GuestEntity(){
        setGuestId(System.nanoTime());
    }
    public Long getGuestId() {
        return guestId;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }
    
}
