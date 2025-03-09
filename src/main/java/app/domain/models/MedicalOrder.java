package app.domain.models;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor

public class MedicalOrder {
    
    private long medicalOrderId;
    private String petId;
    private String description;
    private String ownerId;
    private String petName;
    private String veterinarianId;
    private String medication;
    private String dosage;
    private String Date;
}
