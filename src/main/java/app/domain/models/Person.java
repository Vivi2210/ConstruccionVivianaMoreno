package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    
    private long PersonId;
    private String name;
    private String role;
    private int age;
    
}
