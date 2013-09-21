package entity.accommodation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import entity.common.EmployeeEntity;

@Entity
public class EmployeeScheduleEntity implements Serializable {

    @Id
    private Long scheduleId;
    private String shift;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date scheduleDate;
    @ManyToMany(targetEntity = EmployeeEntity.class, cascade = {CascadeType.ALL}, mappedBy = "schedules")
    private Collection<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();

    public EmployeeScheduleEntity(){
        setScheduleId(System.nanoTime());
    }
    
    public void create(String shift, Date scheduleDate) {
        this.shift = shift;
        this.scheduleDate = scheduleDate;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

  

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Date getDate() {
        return scheduleDate;
    }

    public void setDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Collection<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<EmployeeEntity> employees) {
        this.employees = employees;
    }
}