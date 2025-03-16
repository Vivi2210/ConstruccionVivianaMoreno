package app.domain.services;

import app.domain.models.MedicalHistory;
import app.ports.MedicalHistoryPort;
import java.util.List;
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

    public List<MedicalHistory> getMedicalHistoryByPetId(String petId) throws Exception {
        List<MedicalHistory> historyList = medicalHistoryPort.findByPetId(Long.parseLong(petId));

        if (historyList.isEmpty()) {
        throw new Exception("No se encontró un historial médico para esta mascota.");
        }
        return historyList;
}

    public void updateMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        if (medicalHistory == null) {
            throw new Exception("El historial médico no puede ser nulo.");
        }
    }
}
