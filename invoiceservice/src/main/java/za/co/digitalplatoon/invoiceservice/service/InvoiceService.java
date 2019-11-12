package za.co.digitalplatoon.invoiceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.invoiceservice.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.repository.InvoiceRepository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public void addInvoice(Invoice invoice){
        invoice.setInvoiceDate(new Date());
        invoiceRepository.save(invoice);
    }

    public List<Invoice> viewAllInvoices(){
        return invoiceRepository.findAll();
    }

    public Invoice viewInvoice(long id) {
        return invoiceRepository.findById(id).get();
    }
}
