/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author liuyang
 */
@Entity
public class InvoiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar invoiceDate;
    
/*    @OneToOne(mappedBy = "invoice")
    private ReceiptEntity receipt = new ReceiptEntity();*/
    @ManyToOne
    private TenantEntity tenant = new TenantEntity();

    public InvoiceEntity() {
        setInvoiceId(System.nanoTime());
    }
    
    
    
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Calendar getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Calendar invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
/*
    public ReceiptEntity getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptEntity receipt) {
        this.receipt = receipt;
    }
*/
    public TenantEntity getTenant() {
        return tenant;
    }

    public void setTenant(TenantEntity tenant) {
        this.tenant = tenant;
    }

    
}
