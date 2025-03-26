/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;
import app.domain.models.User;
import app.domain.models.Person;


/**
 *
 * @author Viviana
 */
public interface UserPort {
      
    public void saveUser(User user);
<<<<<<< Updated upstream
    public boolean existUserName(String username);
=======

    public boolean existUserName(String userName);
>>>>>>> Stashed changes

    public User findById(long userId);

<<<<<<< Updated upstream
    public User findByUserName(String username);

    

    
=======
    public User findByUserName(String userName);

    public User findByPersonId(Person person);
>>>>>>> Stashed changes
}
