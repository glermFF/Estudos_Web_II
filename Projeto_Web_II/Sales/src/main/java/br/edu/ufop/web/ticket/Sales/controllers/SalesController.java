package br.edu.ufop.web.ticket.Sales.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.Sales.Services.SalesService;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SalesController {
    
    private final SalesService salesService;

    // List all sales
    @GetMapping("/")
    public ResponseEntity<List<SimpleSalesRecordDTO>> getAllSales(){

        List<SimpleSalesRecordDTO> salesList = salesService.getAllSales();
        
        return ResponseEntity.ok(salesList);
    }

}
