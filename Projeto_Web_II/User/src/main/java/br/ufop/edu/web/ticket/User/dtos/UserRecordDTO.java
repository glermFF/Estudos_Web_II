package br.ufop.edu.web.ticket.User.dtos;

import java.util.UUID;

import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;

public record UserRecordDTO(UUID id, String name, String email, CreditCardNetworkModel creditCardNetworkModel) {
    
}
