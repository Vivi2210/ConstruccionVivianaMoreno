/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.MedicalHistory;
import java.util.Date;
import java.util.List;

/**
 *s
 * @author Viviana
 */
public interface MedicalHistoryPort {

    public void save(MedicalHistory medicalHistory);

    public MedicalHistory findByDate(long petId, Date date);

    public List<MedicalHistory> findByPetId(long petId);

    public void update(MedicalHistory medicalHistory);

    public MedicalHistory findById(long historyId);

    public void delete(long historyId);

    public MedicalHistory findByPetId(String petId);
    
}
