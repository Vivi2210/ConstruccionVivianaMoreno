/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.rest;

import app.Exceptions.BusinessException;
import app.Exceptions.InputsException;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.rest.request.SellerRequest;
import app.adapters.rest.request.VeterinarianRequest;
import app.domain.models.User;
import app.domain.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viviana
 */
@RestController
public class AdminController {
    
    @Autowired
    private AdminService adminservice;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    
    @GetMapping("/")
    public String itsAlive(){
        return"i'm alive";
    }
    
    @GetMapping("/ping")
    public String ping(){
        return"pong";
    }
    
    @PostMapping("/veterinarian")
    public ResponseEntity registerVeterinarian(@RequestBody VeterinarianRequest request) throws Exception{
        try{
        User veterinarian = new User();
        veterinarian.setName(personValidator.nameValidator(request.getName()));
        veterinarian.setDocument(request.getDocument());
        veterinarian.setAge(request.getAge());
        veterinarian.setPassword(userValidator.passwordValidator(request.getPassword()));
        veterinarian.setUserName(userValidator.userNameValidator(request.getUserName()));
        adminservice.registerVeterinarian(veterinarian);
        /*User user = new User();
        user.setName(request.getName());
        user.setDocument(request.getDocument());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName());
        user.setAge(request.getAge());
        User veterinatian = null;
        adminservice.registerVeterinarian(veterinatian);*/
        return  new ResponseEntity ("Se ha registrado el veterinario", HttpStatus.OK);
        
        }catch(BusinessException be){
            return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
            
        }catch (InputsException ie){
            return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);

        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @PostMapping("/seller")
    public ResponseEntity registerSeller(@RequestBody SellerRequest request) throws Exception{
        try{
        User veterinarian = new User();
        veterinarian.setName(personValidator.nameValidator(request.getName()));
        veterinarian.setDocument(request.getDocument());
        veterinarian.setAge(request.getAge());
        veterinarian.setPassword(userValidator.passwordValidator(request.getPassword()));
        veterinarian.setUserName(userValidator.userNameValidator(request.getUserName()));
        adminservice.registerVeterinarian(veterinarian);

        return  new ResponseEntity ("Se ha registrado el vendedor", HttpStatus.OK);
        
        }catch(BusinessException be){
            return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
            
        }catch (InputsException ie){
            return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);

        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
