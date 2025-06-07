package br.ufop.edu.web.ticket.User.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_users")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String creditCardNumber;
    
    @Column(nullable = true) //* Não é preciso pegar dados da cidade. Pode ser deixado o campo como vazio */
    private String city;

    private String email;
    private String password;

    private LocalDateTime creationApp;
    private LocalDateTime updatedApp;

    @PrePersist
    public void recordBefore(){
        this.creationApp = LocalDateTime.now();
        this.updatedApp = LocalDateTime.now();
    }

    @PreUpdate
    public void updateBefore(){
        this.updatedApp = LocalDateTime.now();
    }
}
