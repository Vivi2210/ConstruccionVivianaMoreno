package app.domain.services;

import app.domain.models.MedicalHistory;
import app.ports.MedicalHistoryPort;
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
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryPort medicalHistoryPort;

    public void createMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        if (medicalHistory == null) {
            throw new Exception("El historial médico no puede ser nulo");
        }
        if (medicalHistory.getRegistrationDate() == null) {
            medicalHistory.setRegistrationDate(new Date()); 
        }
        if (medicalHistory.getVeterinaryDoctor() == null || medicalHistory.getVeterinaryDoctor().isEmpty()) {
            throw new Exception("Debe especificar el veterinario que atendió la consulta");
        }
        medicalHistoryPort.save(medicalHistory);
    }

    public MedicalHistory findMedicalHistoryByDate(long petId, Date date) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByDate(petId, date);
        if (history == null) {
            throw new Exception("No se encontró un historial médico para esa fecha y mascota");
        }
        return history;
    }

    public List<MedicalHistory> getMedicalHistoryByPet(long petId) throws Exception {
        List<MedicalHistory> histories = medicalHistoryPort.findByPetId(petId);
        if (histories.isEmpty()) {
            throw new Exception("No hay historial médico registrado para esta mascota");
        }
        return histories;
    }

    public void updateMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        if (medicalHistory == null) {
            throw new Exception("El historial médico no puede ser nulo");
        }
        medicalHistoryPort.update(medicalHistory);
    }

    public void deleteMedicalHistory(long historyId) throws Exception {
        MedicalHistory history = medicalHistoryPort.findById(historyId);
        if (history == null) {
            throw new Exception("No se encontró el historial médico con ese ID");
        }
        medicalHistoryPort.delete(historyId);
    }
}
