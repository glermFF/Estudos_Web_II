package br.edu.ufop.web.ticket.Sales.models;

import java.security.Timestamp;
import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class SalesModel {
    private UUID id;

    private UUID userId;
    private UUID eventId;

    private Date purchaseDate;
    private int purchaseStatus;
    
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
