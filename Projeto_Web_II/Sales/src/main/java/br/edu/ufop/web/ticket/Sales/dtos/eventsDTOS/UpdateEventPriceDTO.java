package br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS;

import java.util.UUID;

public record UpdateEventPriceDTO(UUID id, float price) {}