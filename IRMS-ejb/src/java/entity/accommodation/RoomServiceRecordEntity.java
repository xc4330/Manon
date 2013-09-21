/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author sunjunfan
 */
@Entity
public class RoomServiceRecordEntity implements Serializable {

    @Id
    private Long serviceId;
    private Long EmployeeId;
    private String Name;
    private Boolean Status;
    private int RoomNumber;
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name="RECORD_SERVICE")
    private Collection<RoomServiceEntity> roomservices = new ArrayList<RoomServiceEntity>();
    
    public RoomServiceRecordEntity(){
        setServiceId(System.nanoTime());
    }
    public void create(Long emplyeeid, String name, Boolean status,int roomnumber)
    {
        this.setEmployeeId(EmployeeId);
        this.setName(Name);
        this.setStatus(Status);
        this.setRoomNumber(RoomNumber);
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setEmployeeId(Long EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public void setRoomNumber(int RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public void setRoomservices(Collection<RoomServiceEntity> roomservices) {
        this.roomservices = roomservices;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public String getName() {
        return Name;
    }

    public Boolean getStatus() {
        return Status;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public Collection<RoomServiceEntity> getRoomservices() {
        return roomservices;
    }
    
 
    
}
