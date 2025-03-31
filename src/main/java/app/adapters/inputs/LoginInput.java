/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs;

import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.User;
import app.ports.InputPort;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Viviana
 */
public class LoginInput implements InputPort{
    
    private Map<String, InputPort> inputs;
    @Autowired
    private AdminInput adminInput;
    @Autowired
    private VeterinarianInput veterinarianInput;
    @Autowired
    private SellerInput sellerinput;
    @Autowired 
    private UserValidator userValidator;
    
    private final String MENU="Ingresa una opcion"
            + "\n 1. iniciar sesion"
            + "\n 2. salir";
    @Override
    public void menu() throws Exception{
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option){
            case "1" -> {
                login();
                break;
            }
            case "2" ->{
                System.out.println("saliendose");
                break;
            }
            default ->{
                System.out.println("ingresaste mal, revisa de nuevo");
                break;
            }
        }
    }
    public void login() throws Exception{
        try {
            System.out.println("ingresa el usuario");
            String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
            System.out.println("ingresa la contraseña");
            String password = userValidator.passwordValidator(Utils.getReader().nextLine());

            User user = new User();
            InputPort inputPort = inputs.get(user.getRole());
            if (inputPort !=null){
                inputPort.menu();
            }else{
                System.out.println("no tienens acceso al sistema");
            }
    
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}