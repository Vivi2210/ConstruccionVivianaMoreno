/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.Invoice;
import java.util.List;


public interface InvoicePort {

    public void saveInvoice(Invoice invoice);
    public findById(long invoiceId);
    List<Invoice> findByOwnerId(long ownerDocument);
    

    
    
}
