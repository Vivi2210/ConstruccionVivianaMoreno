/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.services;

import app.domain.models.Invoice;
import app.ports.InvoicePort;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service

public class InvoiceService {
    @Autowired
    private InvoicePort invoicePort;
    
    public void createInvoice(Invoice invoice) throws Exception {
        if (invoice == null){
            throw new Exception("la factura no puede ser nula");
        }
        if (invoice.getProductName() == null || invoice.getProductName().isEmpty()) {
            throw new Exception("producto debe tener nombre");
            
        }
        if (invoice.getPrice() <=0 || invoice.getAmount() <= 0){
            throw new Exception("precio debe ser mayor a 0");
            
        }
        invoice.setInvoiceDate(new Date()); 
        invoicePort.save(invoice);
    }
    public Invoice findInvoiceById(int invoiceId) throws Exception {
        Invoice invoice = invoicePort.findById(invoiceId);
        if (invoice == null) {
            throw new Exception("No se encontró una factura con ese ID");
        }
        return invoice;
    }
  
    public List<Invoice> getAllInvoices() {
        return invoicePort.getAllInvoices();
    }
    
    public List<Invoice> findInvoicesByOwner(long ownerId) throws Exception {
        List<Invoice> invoices = invoicePort.findByOwnerId(ownerId);
        if (invoices.isEmpty()) {
            throw new Exception("Este dueño no tiene facturas registradas");
        }
        return invoices;
    }

    public List<Invoice> findInvoicesByPet(long petId) throws Exception {
        List<Invoice> invoices = invoicePort.findByPetId(petId);
        if (invoices.isEmpty()) {
            throw new Exception("No hay facturas registradas para esta mascota");
        }
        return invoices;
    }

    public List<Invoice> findInvoicesByMedicalOrder(long medicalOrderId) throws Exception {
        List<Invoice> invoices = invoicePort.findByMedicalOrderId(medicalOrderId);
        if (invoices.isEmpty()) {
            throw new Exception("No hay facturas asociadas a esta orden médica");
        }
        return invoices;
    }
    
    public void deleteInvoice(int invoiceId) throws Exception {
        Invoice invoice = invoicePort.findById(invoiceId);
        if (invoice == null) {
            throw new Exception("No se encontró una factura con ese ID para eliminar");
        }
        invoicePort.delete(invoiceId);
    }
}
