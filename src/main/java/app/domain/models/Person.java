package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    
    private long personId;
    private String name;
    private String document;
    private String phone;
    
}
