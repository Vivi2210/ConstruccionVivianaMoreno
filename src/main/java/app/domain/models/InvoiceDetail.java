package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class InvoiceDetail {
    
    private long invoiceDetailId;
    private InvoiceHeader invoiceHeader;
    private long invoiceHeaderId;
    private String description;
    private double amount;
    
}
