package br.edu.ufop.web.ticket.Sales.converters;

import br.edu.ufop.web.ticket.Sales.domain.EventsDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateEventDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleEventsRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;

public class EventsConverter {

    public static SimpleEventsRecordDTO toSimpleEventsRecordDTO(EventsModel eventsModel) {
        return new SimpleEventsRecordDTO(eventsModel.getId(),eventsModel.getDescription(),eventsModel.getType(),eventsModel.getPrice());
    }
    
    public static EventsModel toEventsModel(EventsDomain eventsDomain) {
        return EventsModel.builder().id(eventsDomain.getId()).description(eventsDomain.getDescription()).type(eventsDomain.getType()).price(eventsDomain.getPrice()).date(eventsDomain.getDate()).startSales(eventsDomain.getStartSales()).endSales(eventsDomain.getEndSales()).build();
    }

    public static EventsDomain toEventsDomain(CreateEventDTO createEventDTO) {
        return EventsDomain.builder().description(createEventDTO.description()).type(createEventDTO.type()).price(createEventDTO.price()).date(createEventDTO.date()).startSales(createEventDTO.startSales()).endSales(createEventDTO.endSales()).build();
    }

    public static EventsDomain toEventsDomain(SimpleEventsRecordDTO simpleEventsRecordDTO) {
        return EventsDomain.builder().id(simpleEventsRecordDTO.id()).description(simpleEventsRecordDTO.description()).type(simpleEventsRecordDTO.type()).price(simpleEventsRecordDTO.price()).build();
    }
}