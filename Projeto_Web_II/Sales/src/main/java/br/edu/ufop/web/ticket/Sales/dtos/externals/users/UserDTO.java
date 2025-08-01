package br.edu.ufop.web.ticket.Sales.dtos.externals.users;

import java.util.UUID;

public record UserDTO(UUID id, String name, String email) {}
