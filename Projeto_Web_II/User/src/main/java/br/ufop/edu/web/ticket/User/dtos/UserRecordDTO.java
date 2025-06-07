package br.ufop.edu.web.ticket.User.dtos;

import java.util.UUID;

public record UserRecordDTO(UUID id, String name, String email) {
    
}
