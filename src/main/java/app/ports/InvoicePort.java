/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.Invoice;
import java.util.List;
import app.domain.models.Person;
import app.domain.models.User;
import app.domain.models.Pet;
/**
 *
 * @author Viviana
 */
public interface InvoicePort {

    public List<Invoice> getAllInvoices();

    public void save(Invoice invoice);

    public Invoice findById(int invoiceId);

    public List<Invoice> findByOwnerId(long ownerId);

    public List<Invoice> findByPetId(long petId);

    public List<Invoice> findByMedicalOrderId(long medicalOrderId);

    public void delete(int invoiceId);

    
    
}
