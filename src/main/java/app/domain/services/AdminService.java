
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
            throw new Exception("numero de documento ya en uso");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("Nombre ya en uso");
        }
        userPort.saveUser(user);
        personPort.savePerson(user);

    }
    public void registerSeller(User seller) throws Exception{
        if (personPort.existPerson(seller.getDocument())){
            throw new Exception("Ya hay una persona con esta cedula");
        }
        if (userPort.existUserName(seller.getUserName())){
            throw new Exception("nombre de usuario ya esta en uso, prueba con otro");
        }
        seller.setRole("seller");
        personPort.savePerson(seller);
        userPort.saveUser(seller);
    }
    public void registerVeterinarian(User veterinarian) throws Exception{
        if(personPort.existPerson(veterinarian.getDocument())){
            throw new Exception("numero de ceula ya en uso, revisa la informacion");
        }
        if (userPort.existUserName(veterinarian.getUserName())){
            throw new Exception("nombre de usuario ya en uso");
        }
        veterinarian.setRole("veterinarian");
        personPort.savePerson(veterinarian);
        userPort.saveUser(veterinarian);
    }
    
}
