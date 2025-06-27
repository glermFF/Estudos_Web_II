package br.ufop.edu.web.ticket.User.dtos;

import br.ufop.edu.web.ticket.User.domain.CreditCardNetworkDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    
    private String name;
    
    private String creditCardNumber;
    private CreditCardNetworkDomain creditCardNetworkDomain;
    private String email;
    private String password;

    private String city;
}
