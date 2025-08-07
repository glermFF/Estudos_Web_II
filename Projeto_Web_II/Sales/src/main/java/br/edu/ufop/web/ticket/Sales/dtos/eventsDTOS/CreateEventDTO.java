package br.edu.ufop.web.ticket.Sales.dtos.eventsDTOS;

import java.sql.Date;

public record CreateEventDTO (String description, int type, float price, Date date, Date startSales, Date endSales){}