/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;

import entity.accommodation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author lenovo
 */
@Entity(name="Transaction")
public class TransactionEntity implements Serializable {
    @Id
    private Long transactionId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transDate;
    private boolean status;
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name="Trans_Item")
    private Collection<ItemEntity> items = new ArrayList<ItemEntity>();
    
    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "transaction")
    private PaymentEntity payment;
    
    @ManyToOne
    private CustomerEntity customer=new CustomerEntity();

    public TransactionEntity(){
        
    }
    public Date getTransDate() {
        return transDate;
    }

    public boolean isStatus() {
        return status;
    }
   
    public Collection<ItemEntity> getItems() {
        return items;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    
    
    public Long getId() {
        return transactionId;
    }

    public void setId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setItems(Collection<ItemEntity> items) {
        this.items = items;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    
}
