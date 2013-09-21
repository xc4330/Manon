/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sunjunfan
 */
@Entity
public class RoomServiceEntity implements Serializable {

    @Id
    private Long serviceId;
    private String Name;
    private float Price;
    @ManyToOne
    private HotelEntity hotel = new HotelEntity();

    public RoomServiceEntity() {
        setServiceId(System.nanoTime());
    }

    public Long getServiceId() {
        return serviceId;
    }

    public String getName() {
        return Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
}
