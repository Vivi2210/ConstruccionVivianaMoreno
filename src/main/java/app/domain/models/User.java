package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class User extends Person {
    private long userId;
    private String username;
    private String password;
    private String role;
}
