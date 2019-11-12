package za.co.digitalplatoon.invoiceservice.invoice;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "invoiceId")
    private long id;
    private String client;
    private long vatRate;
    private Date invoiceDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "invoiceLineItem", joinColumns = @JoinColumn(name = "invoiceId"), inverseJoinColumns = @JoinColumn(name = "lineItemId"))
    private Set<LineItem> lineItems;

    public Invoice(){
    }

    public Invoice(long id, String client, long vatRate, Date invoiceDate, Set<LineItem> lineItems){
        this.id = id;
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
        this.lineItems = lineItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getSubTotal(){
        BigDecimal subTotal = BigDecimal.ZERO;
        if(!this.lineItems.isEmpty()) {
            for (LineItem item : this.lineItems)
                subTotal = subTotal.add(item.getLineItemTotal());
        }
        return subTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getVat(){
          BigDecimal vat = new BigDecimal(this.vatRate).divide(new BigDecimal(100));
          vat = vat.multiply(getSubTotal());
         return vat.setScale(2, BigDecimal.ROUND_HALF_UP) ;
    }

    public BigDecimal getTotal(){
        return getSubTotal().add(getVat()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
