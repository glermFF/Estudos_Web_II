package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.Sales.converters.EventsConverter;
import br.edu.ufop.web.ticket.Sales.domain.EventsDomain;
import br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS.CreateEventDTO;
import br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS.DeleteEventDTO;
import br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS.SimpleEventsRecordDTO;
import br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS.UpdateEventDateDTO;
import br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS.UpdateEventPriceDTO;
import br.edu.ufop.web.ticket.Sales.repositories.IEventsRepository;
import lombok.AllArgsConstructor;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;;

@Service
@AllArgsConstructor
public class EventsService {
    private final IEventsRepository eventsRepository;    

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

    // UPDATE PRICE
    public SimpleEventsRecordDTO updateEventPrice(UpdateEventPriceDTO updateEventPriceDTO) {

        Optional<EventsModel> optional = eventsRepository.findById(updateEventPriceDTO.id());

        if (optional.isEmpty()){
            return null;
        }

        EventsModel eventsModel = optional.get();
        eventsModel.setPrice(updateEventPriceDTO.price());

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(eventsModel));
    }

    // UPDATE DATE
    public SimpleEventsRecordDTO updateEventDate(UpdateEventDateDTO updateEventDateDTO) {
        Optional<EventsModel> optional = eventsRepository.findById(updateEventDateDTO.id());

        if (optional.isEmpty()) {
            return null;
        }

        EventsModel eventsModel = optional.get();
        eventsModel.setDate(updateEventDateDTO.newDate());
        eventsModel.setStartSales(updateEventDateDTO.startSale());
        eventsModel.setEndSales(updateEventDateDTO.endSale());

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(eventsModel));
    }

    // DELETE EVENT
    public void deleteEvent(DeleteEventDTO deleteEventDTO) {
        Optional<EventsModel> optional = eventsRepository.findById(deleteEventDTO.id());

        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Event not found with id: " + deleteEventDTO.id());
        }

        eventsRepository.delete(optional.get());
    }
}
