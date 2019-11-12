package za.co.digitalplatoon.invoiceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.digitalplatoon.invoiceservice.invoice.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
