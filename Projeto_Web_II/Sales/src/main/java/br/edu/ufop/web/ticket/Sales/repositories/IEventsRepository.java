package br.edu.ufop.web.ticket.Sales.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufop.web.ticket.Sales.models.EventsModel;

public interface IEventsRepository extends JpaRepository<EventsModel, UUID>{
    List<EventsModel> findAll();
}
