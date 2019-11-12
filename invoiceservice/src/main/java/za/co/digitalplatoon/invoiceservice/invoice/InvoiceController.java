package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.co.digitalplatoon.invoiceservice.service.InvoiceService;

import java.util.List;
@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public void addInvoice(@RequestBody Invoice invoice){
        invoiceService.addInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> viewAllInvoices(){
        return  invoiceService.viewAllInvoices();
    }

    @GetMapping("{invoiceId}")
    public Invoice viewInvoice(@PathVariable long invoiceId){
        return invoiceService.viewInvoice(invoiceId);
    }
}
