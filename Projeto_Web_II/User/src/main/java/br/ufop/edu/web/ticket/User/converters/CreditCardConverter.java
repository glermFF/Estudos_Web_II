package br.ufop.edu.web.ticket.User.converters;

import br.ufop.edu.web.ticket.User.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.dtos.CreditCardDTO;

public class CreditCardConverter {
    
    public static CreditCardDTO toCreditCardDTO(CreditCardNetworkModel creditCardNetworkModel) {
        return new CreditCardDTO(creditCardNetworkModel.getId(), creditCardNetworkModel.getName());
    }

    public static CreditCardNetworkModel toCreditCardNetworkModel(CreditCardNetworkDomain creditCardDomain) {
        return CreditCardNetworkModel.builder().id(creditCardDomain.getId()).name(creditCardDomain.getName()).build();
    }
}
