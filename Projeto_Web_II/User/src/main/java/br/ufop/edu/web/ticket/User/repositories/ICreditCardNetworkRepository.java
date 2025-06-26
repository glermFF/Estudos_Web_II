package br.ufop.edu.web.ticket.User.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;

public interface ICreditCardNetworkRepository
    extends JpaRepository<CreditCardNetworkModel, UUID> {
    
}