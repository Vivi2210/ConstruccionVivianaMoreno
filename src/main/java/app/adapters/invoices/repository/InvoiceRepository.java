/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.adapters.invoices.repository;

/**
 *
 * @author Viviana
 */

import org.springframework.data.jpa.repository.JpaRepository;
import app.adapters.invoices.entity.InvoiceEntity;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    public InvoiceEntity findByOwnerDocument(long ownerDocument);

    public InvoiceEntity findByInvoiceId(long invoiceId);
}
