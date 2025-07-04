package br.edu.ufop.web.ticket.Sales.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_events")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class EventsModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String description;
    
    private int type;

    private Date date;
    private Date startSales;

    private Date endSales;
    
    private float price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
