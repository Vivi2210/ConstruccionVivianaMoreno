/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs;

import app.adapters.inputs.utils.InvoiceValidator;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.SimpleValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.Invoice;
import app.domain.models.MedicalOrder;
import app.domain.services.SellerService;
import app.ports.InputPort;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Viviana
 */
@Setter
@Getter
@NoArgsConstructor
@Component

public class SellerInput implements InputPort{
    
    
    @Autowired
    private SellerService sellerService;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private SimpleValidator simpleValidator;
    
    
    private final String MENU = "ingresa una opcion: "
            + "\n 1. ver orden medica."
            + "\n 2. vender un producto"
            + "\n 3. consultar factura por su id"
            + "\n 4. consultar factura por su dueño documento"
            + "\n 5. salir";
    
    @Override
    public void menu() throws Exception{
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option){
            case "1" ->
                showMedicalOrders();
            case "2" ->  {  
                try{
                    sellProduct();
                } catch (Exception e){
                    System.out.println("Error" + e.getMessage());
                }
            }    
            case "3" ->{
                try{
                    getInvoiceById();
                } catch (Exception e){
                    System.out.println("Error" + e.getMessage());
                }
            }    
            case "4" -> {
                try{
                    getInvoiceByOwner();
                }catch (Exception e){
                    System.out.println("Error" + e.getMessage());
                }
            }    
            case "5"-> {
                
                System.out.println("saliendose");
            }
            default -> {
                System.out.println("ingresaste una opcion no valida");
            }
        }
    }    

    private void showMedicalOrders() throws Exception {    
        List<MedicalOrder> orders = sellerService.getMedicalOrders();
        if (orders.isEmpty()){
            System.out.println("No hay orden medica");
        }else {
            for (MedicalOrder order : orders){
                System.out.println(order);
            }
        }
    }
    private void sellProduct() throws Exception{
        System.out.println("Ingresa el ID de la orden medica");
        long medicalOrderId= Long.parseLong(Utils.getReader().nextLine());
        System.out.println("Ingresa el documento del dueño de la mascota");
        long ownerDocument = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el id de la mascota");
        long petId= petValidator.petIdValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa el nombre del producto");
        String productName = invoiceValidator.productNameValidator(Utils.getReader().nextLine());
        int amount = invoiceValidator.amountValidator(Utils.getReader().nextLine());
        System.out.println("Ingresa la fecha en el formado (dd/mm(yyyy)");
        String invoiceDateString = Utils.getReader().nextLine();
        invoiceDateString = simpleValidator.dateFormatValidator(invoiceDateString, "dd/mm/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date invoiceDate;
        try{
            invoiceDate = dateFormat.parse(invoiceDateString);
        }catch (ParseException e){
            throw new Exception("fomrato no valido");
        }
        System.out.println("Ingresa el valor a pagar");
        double Price;
        try{
            Price= Double.parseDouble(Utils.getReader().nextLine());
            if (Price <= 0){
                throw new Exception("total a pagar debe ser mayor a 0");
            }
        }catch (NumberFormatException e){
            throw new Exception("total a pagar no es valido, revisa la informacion agregada");
        }
        if (medicalOrderId !=0){
            List<MedicalOrder> orders = sellerService.getMedicalOrders();
            MedicalOrder order = null;
            for (MedicalOrder o : orders){
                if(o.getMedicalOrderId() == medicalOrderId){
                    order = o;
                    break;
                }
            }
        }
        Invoice invoice = new Invoice();
        invoice.setMedicalOrderId(medicalOrderId);
        invoice.setOwnerDocument(ownerDocument);
        invoice.setPrice(Price);
        invoice.setAmount(amount);
        invoice.setInvoiceDate(invoiceDate);
        invoice.setPetId(petId);
    }
    private void getInvoiceById() throws Exception{
        System.out.println("Ingrese el ID de la factura");
        long invoiceId = invoiceValidator.invoiceIdValidator(Utils.getReader().nextLine());
        
        Invoice invoice = sellerService.getInvoiceById(invoiceId);
        System.out.println("la factura es " + invoice);
    }
    private void getInvoiceByOwner() throws Exception{
        System.out.println("Ingrese el dueño del documento");
        long ownerDocument = personValidator.documentValidator(Utils.getReader().nextLine());
        
        List<Invoice> invoices = sellerService.getInvoicesByOwner(ownerDocument);
        System.out.println("factiras del dueño");
        for (Invoice invoice : invoices){
            System.out.println(invoices);
        }
    }
}
