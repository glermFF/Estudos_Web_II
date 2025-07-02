package br.ufop.edu.web.ticket.User.services;

import br.ufop.edu.web.ticket.User.domain.CreditCardNetworkDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.dtos.CreditCardDTO;
import br.ufop.edu.web.ticket.User.dtos.CreditCardNetwork.CreateCreditCardDTO;
import br.ufop.edu.web.ticket.User.converters.CreditCardConverter;
import br.ufop.edu.web.ticket.User.repositories.ICreditCardNetworkRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CreditCardService {
 
    private final ICreditCardNetworkRepository creditCardNetworkRepository;

    // GET ALl
    public List<CreditCardDTO> getAllCreditCard(){
        List<CreditCardNetworkModel> creditCardNetworkModelList = creditCardNetworkRepository.findAll();

        return creditCardNetworkModelList.stream().map(CreditCardConverter::toCreditCardDTO).toList(); //* Procura por cada elemento | Acessa o static para converter cada elemento para DTO */
    }


    public CreditCardDTO getCreditCardNetworkByNumber() {
        
        CreditCardNetworkModel creditCardNetworkModel = new CreditCardNetworkModel(UUID.randomUUID(), "Visa");
        
        return CreditCardConverter.toCreditCardDTO(creditCardNetworkModel);
    }

    // CREATE credit card
    public CreditCardDTO createCreditCard(CreateCreditCardDTO createCreditCardNetworkDTO){
         CreditCardNetworkDomain domain = CreditCardConverter.toCreditCardNetworkDomain(createCreditCardNetworkDTO);

         CreditCardNetworkModel model = CreditCardConverter.toCreditCardNetworkModel(domain);

         return CreditCardConverter.toCreditCardDTO(creditCardNetworkRepository.save(model));
    }

    // GET by id
    public CreditCardDTO getCreditCardNetworkById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<CreditCardNetworkModel>optionalCreditCardModel = creditCardNetworkRepository.findById(uuid); //* Conseguimos verificar se o item foi recuperado ou não */

        if (optionalCreditCardModel.isEmpty()){
            return null;
        }
        
        CreditCardNetworkModel creditCardModel = optionalCreditCardModel.get();
        return CreditCardConverter.toCreditCardDTO(creditCardModel);
    }

    // UPDATE credit card
    public CreditCardDTO setCreditCard(CreditCardNetworkDomain creditCardDomain) {
        CreditCardNetworkModel creditCardNetworkModel = CreditCardConverter.toCreditCardNetworkModel(creditCardDomain);
        CreditCardNetworkModel savedModel = creditCardNetworkRepository.save(creditCardNetworkModel);

        return CreditCardConverter.toCreditCardDTO(savedModel);
    }

    //public CreditCardDTO findByNumber(String creditCardNumber) {Optional<CreditCardNetworkModel> optionalCreditCardModel = creditCardNetworkRepository.findByCreditCardNumber(creditCardNumber);if (optionalCreditCardModel.isEmpty()) {return null;        }CreditCardNetworkModel creditCardNetworkModel = optionalCreditCardModel.get(); return CreditCardConverter.toCreditCardDTO(creditCardNetworkModel);    }

}
