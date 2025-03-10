
package app.domain.services;

import app.domain.models.Invoice;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;
import app.ports.PersonPort;
import app.ports.InvoicePort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    
    @Autowired
    private InvoicePort invoicePort;
    
    public void registeruser(User user) throws Exception {
        if (userPort.existUserName(user.getUsername())) {
            throw new Exception("Nombre de usuario ya en uso");
        }
        personPort.savePerson(user);
        userPort.saveUser(user);
        
    }
    public Person findByPersonId(long personId) throws Exception{
        Person person = personPort.findByPersonId(personId);
        if (person ==null){
            throw new Exception("No hay una persona con esa cedula");
        }
        return person;
    }
    public List<Invoice> getAllInvoices(){
        return invoicePort.getAllInvoices();
    }
}
