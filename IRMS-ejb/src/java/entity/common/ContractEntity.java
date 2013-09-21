/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;

import entity.shoppingmall.OutletEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author liuyang
 */

@Entity
public class ContractEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long contractId;
    
    @OneToOne
    private OutletEntity outlet; // = new OutletEntity();
    
    public ContractEntity(){
        setContractId(System.nanoTime());
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public OutletEntity getOutlet() {
        return outlet;
    }

    public void setOutlet(OutletEntity outlet) {
        this.outlet = outlet;
    }

}
