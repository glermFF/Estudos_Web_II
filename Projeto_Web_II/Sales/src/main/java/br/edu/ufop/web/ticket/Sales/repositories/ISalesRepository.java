package br.edu.ufop.web.ticket.Sales.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.ticket.Sales.models.SalesModel;

public interface ISalesRepository extends JpaRepository<SalesModel, UUID>{
    Optional<SalesModel> findById(UUID id);
}