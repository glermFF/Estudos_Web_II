package br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS;

import java.sql.Date;
import java.util.UUID;

public record UpdateEventDateDTO (UUID id, Date newDate, Date startSale, Date endSale) {}
