package br.ufop.edu.web.ticket.User.converters;

import br.ufop.edu.web.ticket.User.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.CreateCreditCardDTO;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.CreditCardDTO;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.UpdateCreditCard;
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
        return CreditCardNetworkDomain.builder().name(createCreditCardNetworkDTO.getName()).build(); 
    }

    //* Modelo para Dominio */
    public static CreditCardNetworkModel toCreditCardNetworkModel(CreditCardNetworkDomain creditCardNetworkDomain) {
        return CreditCardNetworkModel.builder().id(creditCardNetworkDomain.getId()).name(creditCardNetworkDomain.getName()).build();
    }
    //* Para o metódo updateCreditCard */
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(UpdateCreditCard updateCreditCard) {
        return CreditCardNetworkDomain.builder().name(updateCreditCard.name()).build();
    }
}