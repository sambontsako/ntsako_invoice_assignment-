package za.co.digitalplatoon.invoiceservice.invoice;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="lineItemId")
    private long id;
    private long quantity;
    private String description;
    private BigDecimal unitPrice;

    public LineItem(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getLineItemTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

}
