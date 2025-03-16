
package app.domain.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Invoice {
    
    private int invoiceId;
    private long petId;
    private long ownerDocument;
    private String productName;
    private double price;
    private int amount;
    private Date invoiceDate;
    private long medicalOrderId;

    public int getInvoiceId() {
        return invoiceId;
    }

    public long getPetId() {
        return petId;
    }

    public long getOwnerDocument() {
        return ownerDocument;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public long getMedicalOrderId() {
        return medicalOrderId;
    }

}
