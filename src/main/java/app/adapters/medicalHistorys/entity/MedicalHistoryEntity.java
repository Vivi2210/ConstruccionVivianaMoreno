/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.medicalHistorys.entity;

import app.adapters.medicalOrders.entity.MedicalOrderEntity;
import app.domain.models.MedicalOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Viviana
 */
@Entity
@Table(name = "medical_histoy")
@Getter
@Setter
@NoArgsConstructor
public class MedicalHistoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medical_history_id")
    private Long medicalHistoryId;
    
    @Column(name="registration_date")
    private Date registrationDate;
    
    @Column(name="veterinary_doctor")
    private String veterinaryDoctor;
    
    @Column(name= "reason_consultation")
    private String reasonConsultation;
    
    @Column(name="symptomatology")
    private String symptomatology;
    
    @Column(name="diagnosis")
    private String diagnosis;
    
    @ElementCollection
    @CollectionTable(name="medical_procedures", joinColumns= @JoinColumn(name="medical_history_id"))
    @Column(name="procedures")
    private List<String> procedures;
    
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="medical_order_id", referencedColumnName = "medical_order_id")
   private MedicalOrder medicalOrder;
   
   @ElementCollection
   @CollectionTable(name="vaccination_history", joinColumns = @JoinColumn(name="medical_history_id"))
   @Column (name="vaccine")
   private List<String> vaccinationHistory;
   
   @ElementCollection
   @CollectionTable(name="medications_allergic", joinColumns= @JoinColumn(name="medical_history_name"))
   @Column(name="medication")
   private List<String> medicationAllergic;
   
   @Column(name= "detail_procedure")
   private String detailProcedure;
   
   @Column(name="cancellation_order")
   private boolean cancellationOrder;

    public Long getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getVeterinaryDoctor() {
        return veterinaryDoctor;
    }

    public String getReasonConsultation() {
        return reasonConsultation;
    }

    public String getSymptomatology() {
        return symptomatology;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<String> getProcedures() {
        return procedures;
    }

    public MedicalOrder getMedicalOrder() {
        return medicalOrder;
    }

    public void setMedicalOrder(MedicalOrder medicalOrder) {
        this.medicalOrder = medicalOrder;
    }



    public List<String> getVaccinationHistory() {
        return vaccinationHistory;
    }

    public List<String> getMedicationAllergic() {
        return medicationAllergic;
    }

    public String getDetailProcedure() {
        return detailProcedure;
    }

    public boolean getCancellationOrder() {
        return cancellationOrder;
    }

    public void setMedicalHistoryId(Long medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setVeterinaryDoctor(String veterinaryDoctor) {
        this.veterinaryDoctor = veterinaryDoctor;
    }

    public void setReasonConsultation(String reasonConsultation) {
        this.reasonConsultation = reasonConsultation;
    }

    public void setSymptomatology(String symptomatology) {
        this.symptomatology = symptomatology;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }



    public void setVaccinationHistory(List<String> vaccinationHistory) {
        this.vaccinationHistory = vaccinationHistory;
    }

    public void setMedicationAllergic(List<String> medicationAllergic) {
        this.medicationAllergic = medicationAllergic;
    }

    public void setDetailProcedure(String detailProcedure) {
        this.detailProcedure = detailProcedure;
    }

    public void setCancellationOrder(boolean cancellationOrder) {
        this.cancellationOrder = cancellationOrder;
    }

 
   
}
