package br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateCreditCardDTO {
    private UUID id;
    private String name;
}
