
package app.adapters.invoices;

import app.adapters.invoices.entity.InvoiceEntity;
import app.adapters.invoices.repository.InvoiceRepository;
import app.domain.models.Invoice;
import app.ports.InvoicePort;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@Service


public class InvoiceAdapter implements InvoicePort{
    
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Override 
    public void saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = invoiceAdapter(invoice);
        invoiceRepository.save(invoiceEntity);
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
    }

    @Override
    public Invoice findByOwnerDocument(long document){
        InvoiceEntity invoiceEntity = invoiceRepository.findByOwnerDocument(document);
        return invoiceAdapter(invoiceEntity);
    }
    
    @Override
    public Invoice findByInvoiceId(long invoiceId) {
        InvoiceEntity invoiceEntity = invoiceRepository.findByInvoiceId(invoiceId);
        return invoiceAdapter(invoiceEntity);
    }    
    
    private Invoice invoiceAdapter(InvoiceEntity invoiceEntity) {
        Invoice invoice = new Invoice();
        invoice.setAmount(invoiceEntity.getAmount());
        invoice.setInvoiceDate(invoiceEntity.getInvoiceDate());
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
        invoice.setMedicalOrderId(invoiceEntity.getMedicalOrderId());
        invoice.setOwnerDocument(invoiceEntity.getOwnerDocument());
        invoice.setPetId(invoiceEntity.getPetId());
        invoice.setProductName(invoiceEntity.getProductName());
        invoice.setPrice(invoiceEntity.getPrice());
        return invoice;
        
    }
    
    private InvoiceEntity invoiceAdapter(Invoice invoice){
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setAmount(invoice.getAmount());
        invoiceEntity.setInvoiceDate(invoice.getInvoiceDate());
        invoiceEntity.setInvoiceId(invoice.getInvoiceId());
        invoiceEntity.setMedicalOrderId(invoice.getMedicalOrderId());
        invoiceEntity.setOwnerDocument(invoice.getOwnerDocument());
        invoiceEntity.setPetId(invoice.getPetId());
        invoiceEntity.setProductName(invoice.getProductName());
        invoiceEntity.setPrice(invoice.getPrice());
        return invoiceEntity;
    }


}
