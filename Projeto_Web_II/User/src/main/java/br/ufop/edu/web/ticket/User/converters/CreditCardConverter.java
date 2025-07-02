package br.ufop.edu.web.ticket.User.converters;

import br.ufop.edu.web.ticket.User.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.dtos.CreditCardDTO;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.CreateCreditCardDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //* Define uma classe sem contrutor */
public class CreditCardConverter {
    
    //* DTO para o modelo */
    public static CreditCardDTO toCreditCardDTO(CreditCardNetworkModel creditCardNetworkModel) {
        return new CreditCardDTO(creditCardNetworkModel.getId(), creditCardNetworkModel.getName());
    }

    //* DTO para o dominio */
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(CreateCreditCardDTO createCreditCardNetworkDTO) {
        return CreditCardNetworkDomain.builder().id(createCreditCardNetworkDTO.getId()).name(createCreditCardNetworkDTO.getName()).build(); 
    }

    //* Modelo para Dominio */
    public static CreditCardNetworkModel toCreditCardNetworkModel(CreditCardNetworkDomain creditCardDomain) {
        return CreditCardNetworkModel.builder().id(creditCardDomain.getId()).name(creditCardDomain.getName()).build();
    }

    //* Dominio para o modelo */
    //public static CreditCardNetworkDomain toCreditCardNetworkDomain(CreditCardNetworkModel creditCardNetworkModel) {return CreditCardNetworkDomain.builder().name(creditCardNetworkModel.getName()).build();}
}
