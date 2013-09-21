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

/**
 *
 * @author lenovo
 */
@Entity
public class ItemEntity implements Serializable {

    @Id
    private Long itemId;
    private double price;
    private String description;

    public ItemEntity(){
        setItemId(System.nanoTime());
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

  
}
