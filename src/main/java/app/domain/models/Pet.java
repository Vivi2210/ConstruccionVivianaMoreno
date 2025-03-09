package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Pet extends User {
    private long petId;
    private String name;
    private String species;
    private String breed;
    private String age;
    private String color;
    private String weight;
    private String allergies;
    private String medicalHistory;
    private String notes;
    

    
}
