package br.edu.ufop.web.ticket.Sales.dtos;

import java.util.UUID;

public record SimpleEventsRecordDTO(UUID id, String description, int type, float price) {}