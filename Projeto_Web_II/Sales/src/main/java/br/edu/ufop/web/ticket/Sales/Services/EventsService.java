package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;

import br.edu.ufop.web.ticket.Sales.converters.EventsConverter;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleEventsRecordDTO;
import br.edu.ufop.web.ticket.Sales.repositories.IEventsRepository;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;;

public class EventsService {
    private final IEventsRepository eventsRepository = null;    

    // GET all events
    public List<SimpleEventsRecordDTO> getAllEvents() {
        List<EventsModel> eventsList = eventsRepository.findAll();
        return eventsList.stream().map(EventsConverter::toSimpleEventsRecordDTO).toList();
    }
}
