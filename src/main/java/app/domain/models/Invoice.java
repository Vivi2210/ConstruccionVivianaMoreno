
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
    private int petId;
    private long ownerId;
    private String productName;
    private double price;
    private int amount;
    private Date invoiceDate;
}
