/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.Pet;
import java.util.List;

        
public interface PetPort {
    public void savePet(Pet pet);
<<<<<<< Updated upstream
    public Pet findByPetId( long PetId);
    public List<Pet> findByOwnerId(long ownerDocument);

=======
    public boolean existPet(long petId);
    public List<Pet> findByOwnerDocument(long ownerDocument);
    public Pet findByPetId(long petId);
>>>>>>> Stashed changes
}
