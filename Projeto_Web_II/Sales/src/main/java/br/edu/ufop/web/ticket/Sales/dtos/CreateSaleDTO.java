package br.edu.ufop.web.ticket.Sales.dtos;

import java.util.UUID;

public record CreateSaleDTO(UUID eventId, UUID userId, int purchaseStatus) {}
