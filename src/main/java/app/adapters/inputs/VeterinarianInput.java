/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs;

import app.adapters.inputs.utils.MedicalHistoryValidator;
import app.adapters.inputs.utils.MedicalOrderValidator;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.SimpleValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.MedicalHistory;
import app.domain.models.MedicalOrder;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.services.VeterinarianService;
import app.ports.InputPort;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Viviana
 */
@NoArgsConstructor
@Component
public class VeterinarianInput implements InputPort{
    
    @Autowired
    private VeterinarianService veterinarianService;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private SimpleValidator simpleValidator;
    @Autowired 
    private MedicalHistoryValidator medicalHistoryValidator;
    @Autowired
    private MedicalOrderValidator medicalOrderValidator;
    
    
    private final String MENU = "Ingresa una opción" 
            + "\n 1. registrar un dueño"
            + "\n 2. registrar mascota"
            + "\n 3. crear historia clinica"
            + "\n 4. consultar historia medica"
            + "\n 5. actualizar historia"
            + "\n 6. realizar orden medida"
            + "\n 7 canelar orden medica"
            + "\n 8. salir";
    
    @Override
    public void menu(){
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option){
            case "1" ->{
                try{
                    registerOwner();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "2"->{
                try{
                    registerPet();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "3"->{
                try{
                    createMedicalHistory();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "4"->{
                try{
                    getMedicalHistoryByPetId();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "5" ->{
                try{
                    updateMedicalHistory();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "6"->{
                try{
                    generateOrder();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "7"->{
                try{
                    cancelOrder();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "8" ->{
                System.out.println("Saliendo");
            }
            default ->{
                System.out.println("ingresaste una opcion incorrecta");
            }
        }
        
    }
    private void registerOwner() throws Exception{
        System.out.println("Ingresa el documento del sueño");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el nombre del dueño");
        String name = personValidator.nameValidator(Utils.getReader().nextLine());
        Person owner = new Person(document, name, "dueño");
        veterinarianService.registerOwner(owner);
    }
    private void registerPet() throws Exception{
        System.out.println("Ingresa el id de la mascota");
        long petId = petValidator.petIdValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el documento del dueño");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa nombre de la mascota");
        String name = petValidator.petNameValidator(Utils.getReader().nextLine());
        System.out.println("ingresa la especie de la mascota");
        String specie = petValidator.speciesValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la edad de la mascota");
        int age = petValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el color del dueño");
        String color= Utils.getReader().nextLine();
        System.out.println("ingresa la raza ");
        String race = Utils.getReader().nextLine();
        System.out.println("Ingresa el tamaño");
        String size = Utils.getReader().nextLine();
        System.out.println("Ingresa el peso");
        Double weight = petValidator.weightValidator(Utils.getReader().nextLine());
        
        Pet pet = new Pet();
        pet.setAge(age);
        pet.setColor(color);
        pet.setName(name);
        pet.setOwnerDocument(document);
        pet.setPetId(petId);
        pet.setRace(race);
        pet.setSize(size);
        pet.setSpecies(specie);
        pet.setWeight(weight);

    }
    private void createMedicalHistory() throws Exception{
        System.out.println("Ingresa el Id de lamascota");
        long petId = petValidator.petIdValidator(Utils.getReader().nextLine());
        System.out.println("ingresa el nombre del doctor");
        String veterinaryDoctor = Utils.getReader().nextLine();
        System.out.println("Ingresa el motivo de la consulta ");
        String reasonConsultation = medicalHistoryValidator.reasonConsultationValidator(Utils.getReader().nextLine());
        System.out.println("ingresa la simantologia");
        String symptomatology = medicalHistoryValidator.stringValidator(Utils.getReader().nextLine(), "simtomatologia");
        System.out.println("ingrese el diagnostico");
        String diagnosis = medicalHistoryValidator.diagnosisValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese procedimientos realizados separarlos con coma, por favor");
        List<String> procedures = Arrays.asList(medicalHistoryValidator.procedureValidator(Utils.getReader().nextLine()).split(","));
        System.out.println("Ingresa el detalle de procedimiento");
        String datailProcedure = medicalHistoryValidator.stringValidator(Utils.getReader().nextLine(), "detalle");
        System.out.println("Ingrese el historial de vacunaciones separalas con comas");
        List<String> vaccinationHistory = Arrays.asList(medicalHistoryValidator.stringValidator(Utils.getReader().nextLine(),"historial vacunas ").split(","));
        System.out.println("Ingresa las alergias separar por comas");
        List<String> medicationsAllergic = Arrays.asList(medicalHistoryValidator.stringValidator(Utils.getReader().nextLine(), "alegrias a medicamentso").split(","));
        System.out.println("Ingresa la fecha en este formado (dd-mm-yyy)");
        String dateString = medicalHistoryValidator.dateValidator(Utils.getReader().nextLine());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date registrationDate;
        try{
            registrationDate = dateFormat.parse(dateString);
        }catch (ParseException e) {
            throw new Exception("ingresaste una fecha incorrecta");
        }
        System.out.println("la orde medica esta cancelada true/false");
        boolean cancellationOrder = Boolean.parseBoolean(Utils.getReader().nextLine());
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setRegistrationDate((java.sql.Date) registrationDate);
        medicalHistory.setVeterinaryDoctor(veterinaryDoctor);
        medicalHistory.setReasonConsultation(reasonConsultation);
        medicalHistory.setSymptomatology(symptomatology);
        medicalHistory.setDiagnosis(diagnosis);
        medicalHistory.setProcedures(procedures);
        medicalHistory.setDateilprocedure(datailProcedure);
        medicalHistory.setVaccinationHistory(vaccinationHistory);
        medicalHistory.setMedicationsAllergic(medicationsAllergic);
        medicalHistory.setCancellationOrder(cancellationOrder);
        
    }
    private void getMedicalHistoryByPetId() throws Exception{
        try{
            System.out.println("ingresa el id de la mascota");
            long petId  = petValidator.petIdValidator(Utils.getReader().nextLine());
            List<MedicalHistory>historyList = veterinarianService.getMedicalHistoryByPetId(String.valueOf(petId));
            historyList.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void updateMedicalHistory() throws Exception{
        try{
            System.out.println("Ingresa el id de la historia medica");
            long medicalHistoryId=simpleValidator.longValidator(Utils.getReader().nextLine(), "id de la historia medica");
            System.out.println("ingresa el nuevo diagnostico");
            String diagnosis = medicalHistoryValidator.procedureValidator(Utils.getReader().nextLine());
            System.out.println("ingresa el nuevo procedimiento");
            String procedure = medicalHistoryValidator.procedureValidator(Utils.getReader().nextLine());
            List<MedicalHistory> historyList = veterinarianService.getMedicalHistoryByPetId(String.valueOf(medicalHistoryId));
            
            if (historyList.isEmpty()){
                throw new Exception("no hay historia medica");
            }
            MedicalHistory history = historyList.get(0);
            history.setDiagnosis(diagnosis);
            history.setDateilprocedure(procedure);
            
            veterinarianService.updateMedicalHistory(history);
            System.out.println("actualizada");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void generateOrder() throws Exception {
    System.out.println("Ingrese el ID de la mascota:");
    long petId = petValidator.petIdValidator(Utils.getReader().nextLine());

    System.out.println("Ingrese la cédula del veterinario:");
    long veterinarianId = personValidator.documentValidator(Utils.getReader().nextLine());

    System.out.println("Ingrese la cédula del dueño de la mascota:");
    long ownerId = personValidator.documentValidator(Utils.getReader().nextLine());

    System.out.println("Ingrese el nombre del medicamento:");
    String medication = medicalOrderValidator.medicationValidator(Utils.getReader().nextLine());

    System.out.println("Ingrese la fecha de ingreso (dd/MM/yyyy):");
    String entryDateString = Utils.getReader().nextLine();
    entryDateString = simpleValidator.dateFormatValidator(entryDateString, "dd/MM/yyyy");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date entryDate;
    try {
        entryDate = dateFormat.parse(entryDateString);
    } catch (ParseException e) {
        throw new Exception("Formato de fecha inválido.");
    }   

    MedicalOrder medicalOrder = new MedicalOrder();
    medicalOrder.setPetId(petId);
    medicalOrder.setVeterinarianId(veterinarianId);
    medicalOrder.setOwnerId(ownerId);
    medicalOrder.setMedication(medication);
    medicalOrder.setEntryDate(entryDate);
    medicalOrder.setCanceled(false); 

    }
    private void cancelOrder() throws Exception {
    System.out.println("Ingrese el ID de la orden médica a cancelar:");
    long medicalOrderId = medicalOrderValidator.longValidator(Utils.getReader().nextLine(), "ID de la orden médica");

    MedicalOrder medicalOrder = veterinarianService.getMedicalOrderById(medicalOrderId);

    if (medicalOrder == null) {
        throw new Exception("No se encontró una orden médica con el ID ingresado.");
    }

    if (medicalOrder.isCanceled()) {
        System.out.println("La orden médica ya está cancelada.");
        return;
    }

    medicalOrder.setCanceled(true);

}



    
    
}
