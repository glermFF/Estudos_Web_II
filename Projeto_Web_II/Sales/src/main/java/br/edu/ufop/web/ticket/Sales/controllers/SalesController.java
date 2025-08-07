package br.edu.ufop.web.ticket.Sales.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.Sales.Services.SalesService;
import br.edu.ufop.web.ticket.Sales.Services.client.UserServiceClient;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.DeleteSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.dtos.UpdatePurchaseStatusDTO;
import br.edu.ufop.web.ticket.Sales.dtos.externals.users.UserDTO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SalesController {
    
    private final SalesService salesService;
    private final UserServiceClient userServiceClient;
    
    @GetMapping("/status")
    public ResponseEntity<String> serviceStatus(){
        return ResponseEntity.ok("[STATUS] Sales Service is running");
    }

    //* GET all sales
    @GetMapping("/list-sales")
    public ResponseEntity<List<SimpleSalesRecordDTO>> getAllSales(){
        List<SimpleSalesRecordDTO> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userList = userServiceClient.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    //* CREATE sale */
    @PostMapping
    public ResponseEntity<SimpleSalesRecordDTO> createSale(@RequestBody CreateSaleDTO createSaleDTO) {
        SimpleSalesRecordDTO createdSale = salesService.createSale(createSaleDTO);
        return ResponseEntity.ok(createdSale);
    }

    //* UPDATE purchaseStatus */
    @PutMapping("/purchase-status")
    public ResponseEntity<SimpleSalesRecordDTO> updatePurchaseType(@RequestBody UpdatePurchaseStatusDTO updatePurchaseStatusDTO){
        SimpleSalesRecordDTO updatePurchase = salesService.updatePurchaseType(updatePurchaseStatusDTO);
        return ResponseEntity.ok(updatePurchase);
    } 

    //* DELETE sale */
    @DeleteMapping("/remove-sale")
    public ResponseEntity<Object> deleteSale(@RequestBody DeleteSaleDTO deleteSaleDTO){
        salesService.deleteSale(deleteSaleDTO);
        return ResponseEntity.ok("Sale has been deleted");
    } 
}
