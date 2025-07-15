package br.edu.ufop.web.ticket.Sales.dtos;

import java.sql.Date;
import java.util.UUID;

public record SimpleEventsRecordDTO(UUID id, String description, int type, float price, Date date, Date startSales, Date endSales) {}