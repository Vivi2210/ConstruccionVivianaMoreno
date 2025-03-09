package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Owner extends User {
    private long ownerId;
    private String address;
    private String city;
    private String state;

    

    
}
