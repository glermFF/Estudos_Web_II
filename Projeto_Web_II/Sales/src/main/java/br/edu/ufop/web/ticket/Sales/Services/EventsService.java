package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.Sales.converters.EventsConverter;
import br.edu.ufop.web.ticket.Sales.domain.EventsDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateEventDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleEventsRecordDTO;
import br.edu.ufop.web.ticket.Sales.repositories.IEventsRepository;
import lombok.AllArgsConstructor;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;;

@Service
@AllArgsConstructor
public class EventsService {
    private final IEventsRepository eventsRepository = null;    

    // GET all events
    public List<SimpleEventsRecordDTO> getAllEvents() {
        List<EventsModel> eventsList = eventsRepository.findAll();
        return eventsList.stream().map(EventsConverter::toSimpleEventsRecordDTO).toList();
    }

    // CREATE EVENT
    public SimpleEventsRecordDTO createEvent(CreateEventDTO eventDTO) {
        
        EventsDomain domain = EventsConverter.toEventsDomain(eventDTO);

        EventsModel model = EventsConverter.toEventsModel(domain);

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(model));
    }
}
