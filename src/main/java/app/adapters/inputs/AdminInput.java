/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs;

import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.User;
import app.domain.services.AdminService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Viviana
 */

@Setter
@Getter
@NoArgsConstructor
@Component

public class AdminInput implements InputPort{
    
    @Autowired
    private PersonValidator personValidator;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private AdminService adminService;
    
    private final String MENU="Ingrese una opcion: "
            + "\n 1. registro veterinario"
            + "\n 2. registro vendedor"
            + "\n 3. salir";
    
    @Override
    public void menu(){
        System.out.println("MENU");
        String option = Utils.getReader().nextLine();
        switch (option){
            case "1" -> {
                try{
                    registerVeterinarian();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }  
            }
            case "2" ->{
                try{
                    registerSeller();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            
            }
            case "3" -> {
                System.out.println("gracias.");
            }
            default ->{
                System.out.println("Has ingresado una opción no valida");
            }
            
        }
    }    
    
    private void registerVeterinarian() throws Exception{
        System.out.println("Ingresa el nombre del veterinario: ");
        String name = personValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el documento de veterinario");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la edad del veterinario ");
        int age = personValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el usuario del veterinario");
        String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la contraseña del veterinario");
        String password = userValidator.passwordValidator(Utils.getReader().nextLine());
        User veterinarian = new User();
        veterinarian.setName(name);
        veterinarian.setAge(age);
        veterinarian.setDocument(document);
        veterinarian.setUserName(userName);
        veterinarian.setPassword(password);
        veterinarian.setRole("veterinarian");
    }
    private void registerSeller() throws Exception{
        System.out.println("Ingresa el nombre del vendedor");
        String name= personValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la cedula del vendedor");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la edad del vendedor");
        int age = personValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el usuario del vendedor");
        String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la contraseña del vendedor");
        String password = userValidator.passwordValidator(Utils.getReader().nextLine());
        User seller = new User();
        seller.setName(name);
        seller.setAge(age);
        seller.setDocument(document);
        seller.setUserName(userName);
        seller.setPassword(password);
        seller.setRole("seller");
        
    }
}

