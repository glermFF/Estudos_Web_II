package br.ufop.edu.web.ticket.User.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufop.edu.web.ticket.User.dtos.CreditCardDTO;
import br.ufop.edu.web.ticket.User.services.CreditCardService;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.CreateCreditCardDTO;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/cc_network")
@AllArgsConstructor
public class CreditCardNetworkController {
    
    private final CreditCardService creditCardService;

    @GetMapping
    public ResponseEntity<List<CreditCardDTO>> getAll() {
        return ResponseEntity.ok(creditCardService.getAllCreditCard());
    }

    @PostMapping
    public ResponseEntity<CreditCardDTO> createCreditCard(@RequestBody CreateCreditCardDTO CreateCreditCardNetworkDTO){

        CreditCardDTO creditCardDTO = creditCardService.createCreditCard(CreateCreditCardNetworkDTO);

        return ResponseEntity.ok(creditCardDTO);
    }
}