/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;
import entity.shoppingmall.OutletEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author liuyang
 */
@Entity
public class TenantEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tenantId;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tenant")
    private Collection<InvoiceEntity> invoice = new ArrayList<InvoiceEntity>();
    @OneToMany(cascade = {CascadeType.PERSIST})
    private Collection<ReceiptEntity> receipt = new ArrayList<ReceiptEntity>();
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "tenant")
    private Collection<OutletEntity> outlets = new ArrayList<OutletEntity>();

    public TenantEntity() {
        setTenantId(System.nanoTime());
    }

    
    
    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<InvoiceEntity> getInvoice() {
        return invoice;
    }

    public void setInvoice(Collection<InvoiceEntity> invoice) {
        this.invoice = invoice;
    }

    public Collection<ReceiptEntity> getReceipt() {
        return receipt;
    }

    public void setReceipt(Collection<ReceiptEntity> receipt) {
        this.receipt = receipt;
    }
    
    public Collection<OutletEntity> getOutlets() {
        return outlets;
    }

    public void setOutlets(Collection<OutletEntity> outlets) {
        this.outlets = outlets;
    }

    
}