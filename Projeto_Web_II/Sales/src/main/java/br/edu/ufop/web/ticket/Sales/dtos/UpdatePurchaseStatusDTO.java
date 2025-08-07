package br.edu.ufop.web.ticket.Sales.dtos;

import java.util.UUID;

public record UpdatePurchaseStatusDTO(UUID id, UUID eventId, UUID userId, int purchaseStatus) {}