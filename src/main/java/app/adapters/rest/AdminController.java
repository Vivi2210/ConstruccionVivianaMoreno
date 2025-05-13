/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.rest;

import app.adapters.rest.request.VeterinarianRequest;
import app.domain.models.User;
import app.domain.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired AdminService adminservice;
    
    @GetMapping("/")
    public String itsAlive(){
        return"i'm alive";
    }
    
    @GetMapping("/ping")
    public String ping(){
        return"pong";
    }
    
    @PostMapping("/veterinarian")
    public String registerVeterinarian(@RequestBody VeterinarianRequest request) throws Exception{
        User veterinarian = new User();
        veterinarian.setName(request.getName());
        veterinarian.setDocument(request.getDocument());
        veterinarian.setAge(request.getAge());
        veterinarian.setPassword(request.getPassword());
        veterinarian.setUserName(request.getUserName());
        adminservice.registerVeterinarian(veterinarian);
        /*User user = new User();
        user.setName(request.getName());
        user.setDocument(request.getDocument());
        user.setPassword(request.getPassword());
        user.setUserName(request.getUserName());
        user.setAge(request.getAge());
        User veterinatian = null;
        adminservice.registerVeterinarian(veterinatian);*/
        return   "Se ha registrado el veterinario";
    }
    
}
