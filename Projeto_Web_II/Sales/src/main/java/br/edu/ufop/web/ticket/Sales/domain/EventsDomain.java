package br.edu.ufop.web.ticket.Sales.domain;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class EventsDomain {
    private UUID id;

    private String description;
    
    private int type;

    private Date date;
    private Date startSales;

    private Date endSales;
    
    private float price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
