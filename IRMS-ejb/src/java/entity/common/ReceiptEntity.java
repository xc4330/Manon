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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author liuyang
 */
@Entity
public class ReceiptEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar receiptDate;

    /*
    @OneToOne
    private InvoiceEntity invoice = new InvoiceEntity();
     */
    public ReceiptEntity() {
         setReceiptId(System.nanoTime());
    }
    
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Calendar getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Calendar receiptDate) {
        this.receiptDate = receiptDate;
    }
/*
    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }
*/
}
