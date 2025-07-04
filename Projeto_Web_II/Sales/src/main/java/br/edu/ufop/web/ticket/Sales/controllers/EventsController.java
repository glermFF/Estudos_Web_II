package br.edu.ufop.web.ticket.Sales.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufop.web.ticket.Sales.Services.EventsService;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleEventsRecordDTO;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    // List all events
    @GetMapping("/")
    public ResponseEntity<List<SimpleEventsRecordDTO>> getAllEvents() {

        List<SimpleEventsRecordDTO> eventsList = eventsService.getAllEvents();
        
        return ResponseEntity.ok(eventsList); 
    }
    
}
