package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Pet {
    private long petId;
    private String name;
    private long ownerId;
    private String species;
    private int age;
    private String color;
    private String race;
    private String size;
    private double weight;

    public int getPetId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
