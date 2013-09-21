/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.shoppingmall;

import entity.common.ContractEntity;
import entity.common.TenantEntity;
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
public class OutletEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long outletId;

    @OneToOne(mappedBy="outlet")
    private ContractEntity contract;// = new ContractEntity();
    @ManyToOne
    private TenantEntity tenant = new TenantEntity();
    
    @ManyToOne
    private ShoppingMallEntity shoppingMall = new ShoppingMallEntity();
    
    private String name;

    public OutletEntity() {
        setOutletId(System.nanoTime());
    }
  
    public Long getOutletId() {
        return outletId;
    }

    public void setOutletId(Long outletId) {
        this.outletId = outletId;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContract(ContractEntity contract) {
        this.contract = contract;
    }

    public TenantEntity getTenant() {
        return tenant;
    }

    public void setTenant(TenantEntity tenant) {
        this.tenant = tenant;
    }

    public ShoppingMallEntity getShoppingMall() {
        return shoppingMall;
    }

    public void setShoppingMall(ShoppingMallEntity shoppingMall) {
        this.shoppingMall = shoppingMall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}