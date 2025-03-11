package app.domain.services;

import app.domain.models.MedicalHistory;
import app.ports.MedicalHistoryPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class VeterinarianService {

    @Autowired
    private MedicalHistoryPort medicalHistoryPort;

    public void createMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        if (medicalHistory == null) {
            throw new Exception("El historial médico no puede ser nulo.");
        }
        medicalHistoryPort.save(medicalHistory);
    }

    public MedicalHistory getMedicalHistoryByPetId(String petId) throws Exception {
        MedicalHistory history = medicalHistoryPort.findByPetId(petId);
        if (history == null) {
            throw new Exception("No se encontró un historial médico para esta mascota.");
        }
        return history;
    }
    public void updateMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        if (medicalHistory == null) {
            throw new Exception("El historial médico no puede ser nulo.");
        }
        medicalHistoryPort.update(medicalHistory);
    }
}
