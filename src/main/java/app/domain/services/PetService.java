
package app.domain.services;

import app.domain.models.Pet;
import app.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PetService {
    
    @Autowired
    private PetPort petPort;
    public void registerPet(Pet pet) throws Exception {
        if (pet == null){
            throw new Exception("La mascota no puede ser nulla");
        }
        petPort.savePet(pet);
    }
    public Pet findByPetId(long petId) throws Exception {
        Pet pet =petPort.findByPetId(petId);
        if (pet == null){
            throw new Exception("no hay una mascota con esa identificacion");
            
        }
        return pet;
    }
    public List<Pet> findPetsByOwner(long ownerId) throws Exception {
       List<Pet> pets = petPort.findByOwnerId(ownerId);
       if (pets.isEmpty()) {
           throw new Exception("Dueño no tiene mascota");
       }
       return pets;
    }
    public void updatePet(Pet pet) throws Exception {
        if (pet == null || pet.getPetId() == 0){
        }
        petPort.updatePet(pet);
    }
    public void deletePet(long petId) throws Exception{
        petPort.deletePet(petId);
    }
    
}
