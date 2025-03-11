package app.domain.models;
import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor


public class MedicalHistory {
    private Date registrationDate;
    private String veterinaryDoctor;
    private String reasonConsultation;
    private String symptomatology;
    private String diagnosis;
    private List<String> procedures;
    private MedicalOrder medicalOrder;
    private List<String> vaccinationHistory;
    private List<String> medicationsAllergic;
    private String dateilprocedure;
    private boolean cancellationOrder;

    public Object getRegistrationDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setRegistrationDate(java.util.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getVeterinaryDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}