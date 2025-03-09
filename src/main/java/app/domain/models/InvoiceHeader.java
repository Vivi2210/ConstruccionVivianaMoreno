package app.domain.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class InvoiceHeader {

    private long InvoiceHeaderId;
    private Person person;
    private Owner owner;
    private InvoiceDetail invoiceDetail;
    private boolean status;
    private Date  dateCreated;
    private double amount;

    
}
