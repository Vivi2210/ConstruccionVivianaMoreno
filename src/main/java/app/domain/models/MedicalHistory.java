package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor


public class MedicalHistory {
    private long medicalHistoryId;
    private String description;
    private String diagnosis;
    private String treatment;
    private String date;
    private String medication;
    private String notes;
    private String allergies;
    private String bloodType;


}