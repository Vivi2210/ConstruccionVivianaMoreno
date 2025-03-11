package app.domain.services;

import app.domain.models.MedicalOrder;
import app.ports.MedicalOrderPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Service
public class MedicalOrderService {

    @Autowired
    private MedicalOrderPort medicalOrderPort;

    public void createMedicalOrder(MedicalOrder medicalOrder) throws Exception {
        if (medicalOrder == null) {
            throw new Exception("La orden médica no puede ser nula");
        }
        if (medicalOrder.getPetId() == null || medicalOrder.getOwnerId() == null) {
            throw new Exception("Debe especificar la mascota y su dueño");
        }
        if (medicalOrder.getMedication() == null || medicalOrder.getMedication().isEmpty()) {
            throw new Exception("Debe especificar el medicamento recetado");
        }
        medicalOrder.setEntryDate(new Date());
        medicalOrderPort.save(medicalOrder);
    }

    public MedicalOrder findMedicalOrderById(long orderId) throws Exception {
        MedicalOrder medicalOrder = medicalOrderPort.findById(orderId);
        if (medicalOrder == null) {
            throw new Exception("No se encontró una orden médica con ese ID");
        }
        return medicalOrder;
    }

    public List<MedicalOrder> getAllMedicalOrders() {
        return medicalOrderPort.getAllMedicalOrders();
    }

    public List<MedicalOrder> findMedicalOrdersByPet(long petId) throws Exception {
        List<MedicalOrder> orders = medicalOrderPort.findByPetId(petId);
        if (orders.isEmpty()) {
            throw new Exception("No hay órdenes médicas registradas para esta mascota");
        }
        return orders;
    }

    public void cancelMedicalOrder(long orderId) throws Exception {
        MedicalOrder medicalOrder = medicalOrderPort.findById(orderId);
        if (medicalOrder == null) {
            throw new Exception("No se encontró una orden médica con ese ID");
        }
        medicalOrder.setCancellationOrder(true);
        medicalOrderPort.update(medicalOrder);
    }
}
