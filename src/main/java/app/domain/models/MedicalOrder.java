package app.domain.models;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor

public class MedicalOrder {
    
    private long medicalOrderId;
    private long petId;
    private long ownerId;
    private String petName;
    private long veterinarianId;
    private String medication;
    private String dosage;
    private Date entryDate;

    public MedicalOrder(long medicalOrderId, long petId, long ownerId, String petName, long veterinarianId, String medication, String dosage, Date entryDate) {
        this.medicalOrderId = medicalOrderId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.petName = petName;
        this.veterinarianId = veterinarianId;
        this.medication = medication;
        this.dosage = dosage;
        this.entryDate = entryDate;
    }

    public long getMedicalOrderId() {
        return medicalOrderId;
    }

    public long getPetId() {
        return petId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getPetName() {
        return petName;
    }

    public long getVeterinarianId() {
        return veterinarianId;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setMedicalOrderId(long medicalOrderId) {
        this.medicalOrderId = medicalOrderId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setVeterinarianId(long veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

  
}
