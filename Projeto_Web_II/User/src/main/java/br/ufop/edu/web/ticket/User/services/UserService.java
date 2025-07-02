package br.ufop.edu.web.ticket.User.services;

import br.ufop.edu.web.ticket.User.domain.UserDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.models.UserModel;
import br.ufop.edu.web.ticket.User.Enums.EnumUserType;
import br.ufop.edu.web.ticket.User.converters.UserConverter;

import br.ufop.edu.web.ticket.User.domain.usecase.CreateUserUsecase;
import br.ufop.edu.web.ticket.User.domain.usecase.UpdateCreditCardUseCase;
import br.ufop.edu.web.ticket.User.domain.usecase.UpdateUserPasswordUseCase;

import br.ufop.edu.web.ticket.User.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.DeleteUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserCreditCardDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserPasswordDTO;
import br.ufop.edu.web.ticket.User.dtos.UserRecordDTO;

import br.ufop.edu.web.ticket.User.repositories.ICreditCardNetworkRepository;
import br.ufop.edu.web.ticket.User.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService { //* Funciona da mesma maneira como um SingleTom */
    
    private IUserRepository userRepository;
    private ICreditCardNetworkRepository creditCardRepository;

    public List<UserRecordDTO> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();

        return userModelList.stream().map(UserConverter::toUserRecordDTO).toList(); //* */
    } //* Converte cada elemento da lista (L:20) de UserModel ao UserRecordDTO*/

    public UserRecordDTO createUser(CreateUserDTO createUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        CreateUserUsecase createUserUsecase = new CreateUserUsecase(userDomain);createUserUsecase.validate();

        UserModel userModel = UserConverter.touUserModel(userDomain); //* Recupera os dados por meio do UserModel */

        userModel.setUserType(EnumUserType.CUSTOMER); //* Define o tipo de usuário como cliente */

        //* Salva os devidos dados */
        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    public UserRecordDTO getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<UserModel>optionalUserModel = userRepository.findById(uuid); //* Conseguimos verificar se o item foi recuperado ou não */

        if (optionalUserModel.isEmpty()){
            return null;
        }
        
        UserModel userModel = optionalUserModel.get();
        return UserConverter.toUserRecordDTO(userModel); //* Recuperado o item, retorna como UserConverter */
    }

    public List<UserRecordDTO> getUserByName(String name){ //* Semelhante ao método getAllUsers */
        
        List<UserModel> userModel = userRepository.findAllByNameContainingIgnoreCase(name);

        return userModel.stream().map(UserConverter::toUserRecordDTO).toList();
    }

    //!! Implementar função semelhante a anterior voltada para a cidade //public List<UserRecordDTO> getUserByCity(String city){ List<UserModel> userModel = userRepository.findByCity(city) return userModel.stream().map(UserConverter::toUserRecordDTO).toList()}

    public UserRecordDTO updateUser(UpdateUserDTO updateUserDTO) {

        //* Converter para entidade do domínio */
        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);

        //* Validar conforme as useCase */

        //* Recuperar entidade atual no banco de dados*/
        Optional<UserModel> optionalUserDTO = userRepository.findById(updateUserDTO.getId());

        //* Verifica se o devido ID existe */
        if (optionalUserDTO.isEmpty()){
            return null;
        }

        UserModel userModel = UserConverter.touUserModel(userDomain);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));

    }

    public UserRecordDTO updatePassword(UpdateUserPasswordDTO updateUserPasswordDTO) {

        //* Recupera os dados da entidade */
        Optional<UserModel> optionalUserPasswordDTO = userRepository.findById(updateUserPasswordDTO.getId());

        UserModel userModel = optionalUserPasswordDTO.get();

        //* Verifica se estão vazios */
        if (optionalUserPasswordDTO.isEmpty()){
            return null;
        }
        
        //* No usecase utiliza e compara os dados coletados com os novos "settados" */
        UpdateUserPasswordUseCase useCase = new UpdateUserPasswordUseCase(userModel.getEmail(), updateUserPasswordDTO.getEmail(), userModel.getPassword(), updateUserPasswordDTO.getOldPassword());
        useCase.validate();

        userModel.setPassword(updateUserPasswordDTO.getNewPassword());

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    public UserRecordDTO updateCreditCard(UpdateUserCreditCardDTO updateUserCreditCardDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(updateUserCreditCardDTO.getId());
        
        
        if (optionalUserModel.isEmpty()){
            return null;
        }

        Optional<CreditCardNetworkModel> optCreditCard = creditCardRepository.findById(updateUserCreditCardDTO.getCreditCardId());

        if (optCreditCard.isEmpty()) {
            return null;
        }


        UserModel userModel = optionalUserModel.get();
        CreditCardNetworkModel creditCardNetworkModel = optCreditCard.get();

        userModel.setCreditCardNumber(updateUserCreditCardDTO.getCreditCardNumber());

        userModel.setCreditCardNetworkModel(creditCardNetworkModel);

        UpdateCreditCardUseCase useCase = new UpdateCreditCardUseCase(userModel.getCreditCardNetworkModel().getId(), updateUserCreditCardDTO.getCreditCardId(), userModel.getCreditCardNumber(), updateUserCreditCardDTO.getCreditCardNumber());
        useCase.validate();

        userModel.setCreditCardNumber(updateUserCreditCardDTO.getCreditCardNumber());
        
        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    public void deleteUser(DeleteUserDTO deleteUserDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(deleteUserDTO.id());


        if (optionalUserModel.isEmpty()){
            throw new RuntimeException("User not found");
        }

        userRepository.delete(optionalUserModel.get());
    }
}
