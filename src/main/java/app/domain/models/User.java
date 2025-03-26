package app.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class User extends Person {
    private String username;
    private String password;
<<<<<<< Updated upstream

    public String getUsername() {
        return username;
=======
    
    public User(){     
    }
    public String getUserName() {
        return userName;
>>>>>>> Stashed changes
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< Updated upstream
    public User(String username, String password, long document, String name, String role, int age) {
=======
    public long getUserDocument() {
        return userDocument;
    }

    @Override
    public String getRole() {
        return role;
    }

    public void setUserDocument(long userDocument) {
        this.userDocument = userDocument;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
    public User(String userName, String password, long document, String name, String role, int age) {
>>>>>>> Stashed changes
        super(document, name, role, age);
        this.username = username;
        this.password = password;
    }

<<<<<<< Updated upstream
  
=======
>>>>>>> Stashed changes
}
