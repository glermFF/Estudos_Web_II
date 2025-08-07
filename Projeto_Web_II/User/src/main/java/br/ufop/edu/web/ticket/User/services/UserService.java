package br.ufop.edu.web.ticket.User.services;

import br.ufop.edu.web.ticket.User.domain.UserDomain;
import br.ufop.edu.web.ticket.User.models.CreditCardNetworkModel;
import br.ufop.edu.web.ticket.User.models.UserModel;
import br.ufop.edu.web.ticket.User.Enums.EnumUserType;
import br.ufop.edu.web.ticket.User.converters.UserConverter;

import br.ufop.edu.web.ticket.User.domain.usecase.CreateUserUsecase;
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
public class UserService {
    
    private final IUserRepository userRepository;
    private final ICreditCardNetworkRepository creditCardRepository;

    // GET 
    public List<UserRecordDTO> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();

        return userModelList.stream().map(UserConverter::toUserRecordDTO).toList();
    }

    // POST
    public UserRecordDTO createUser(CreateUserDTO createUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        CreateUserUsecase createUserUsecase = new CreateUserUsecase(userDomain);createUserUsecase.validate();

        UserModel userModel = UserConverter.touUserModel(userDomain);

        userModel.setUserType(EnumUserType.CUSTOMER);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // GET byId
    public UserRecordDTO getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<UserModel>optionalUserModel = userRepository.findById(uuid);

        if (optionalUserModel.isEmpty()){
            return null;
        }
        
        UserModel userModel = optionalUserModel.get();
        return UserConverter.toUserRecordDTO(userModel); 
    }

    // GET byUserName
    public List<UserRecordDTO> getUserByName(String name){ 
        List<UserModel> userModel = userRepository.findAllByNameContainingIgnoreCase(name);

        return userModel.stream().map(UserConverter::toUserRecordDTO).toList();
    }

    // PUT
    public UserRecordDTO updateUser(UpdateUserDTO updateUserDTO) {
        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);

        Optional<UserModel> optionalUserDTO = userRepository.findById(updateUserDTO.getId());

        if (optionalUserDTO.isEmpty()){
            return null;
        }

        UserModel userModel = UserConverter.touUserModel(userDomain);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // PUT
    public UserRecordDTO updatePassword(UpdateUserPasswordDTO updateUserPasswordDTO) {

        Optional<UserModel> optionalUserPasswordDTO = userRepository.findById(updateUserPasswordDTO.getId());

        UserModel userModel = optionalUserPasswordDTO.get();

        if (optionalUserPasswordDTO.isEmpty()){
            return null;
        }
        
        UpdateUserPasswordUseCase useCase = new UpdateUserPasswordUseCase(userModel.getEmail(), updateUserPasswordDTO.getEmail(), userModel.getPassword(), updateUserPasswordDTO.getOldPassword());
        useCase.validate();

        userModel.setPassword(updateUserPasswordDTO.getNewPassword());

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // PUT
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

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // DELETE
    public void deleteUser(DeleteUserDTO deleteUserDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(deleteUserDTO.id());

        if (optionalUserModel.isEmpty()){
            throw new RuntimeException("User not found");
        }

        userRepository.delete(optionalUserModel.get());
    }
}
