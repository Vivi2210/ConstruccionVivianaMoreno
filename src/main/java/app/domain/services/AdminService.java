
package app.domain.services;

import app.ports.UserPort;
import app.domain.models.User;
import app.ports.PersonPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@NoArgsConstructor
@Service

public class AdminService {
    
    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PersonPort personPort;
    
    
    public void registerUser(User user) throws Exception {
        if (personPort.existPerson(user.getDocument())) {
            throw new Exception("Nombre de usuario ya en uso");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("Nombre ya en uso");
        }
        userPort.saveUser(user);
        personPort.savePerson(user);

    }
    public void registerSeller(String username, String password, long document, int age, String name) throws Exception {
        User seller = new User(username, password, document, name, "seller", age);
        registerUser(seller);
    }
    public void registerVeterinarian(String username, String password, long document, int age, String name) throws Exception {
        User veterinarian = new User(username, password, document, name, "veterinarian", age);
        registerUser(veterinarian);
    }
}
