package app.domain.services;

import app.domain.models.User;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserPort userPort;

    public void registerUser(User user) throws Exception {
        if (userPort.existUserName(user.getUsername())) {
            throw new Exception("El nombre de usuario ya está en uso.");
        }
        userPort.saveUser(user);
    }

  
    public User login(String username, String password) throws Exception {
        User user = userPort.findByUserName(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Usuario o contraseña incorrectos.");
        }
        return user;
    }
}
