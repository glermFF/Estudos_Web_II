package br.edu.ufop.web.ticket.Sales.Services.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ufop.web.ticket.Sales.dtos.externals.users.UserDTO;

@FeignClient("users-service")
public interface UserServiceClient {
    
    @GetMapping("/users")
    List<UserDTO> getAllUsers();
}
