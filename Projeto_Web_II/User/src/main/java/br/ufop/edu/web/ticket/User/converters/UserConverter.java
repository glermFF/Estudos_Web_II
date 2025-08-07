package br.ufop.edu.web.ticket.User.converters;


import br.ufop.edu.web.ticket.User.domain.UserDomain;
import br.ufop.edu.web.ticket.User.models.UserModel;
import br.ufop.edu.web.ticket.User.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UserRecordDTO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) 
public class UserConverter {
    
    public static UserRecordDTO toUserRecordDTO(UserModel userModel){
        return new UserRecordDTO(userModel.getId(), userModel.getName(), userModel.getEmail(), userModel.getCreditCardNetworkModel());
    }

    public static UserModel touUserModel(UserDomain userDomain){
        return UserModel.builder().id(userDomain.getId()).name(userDomain.getName()).creditCardNumber(userDomain.getCreditCardNumber()).email(userDomain.getEmail()).password(userDomain.getPassword()).city(userDomain.getCity()).creditCardNetworkModel(null).build();
    }

    public static UserDomain toUserDomain(CreateUserDTO createUserDTO){
        return UserDomain.builder().name(createUserDTO.getName()).creditCardNumber(createUserDTO.getCreditCardNumber()).email(createUserDTO.getEmail()).password(createUserDTO.getPassword()).city(createUserDTO.getCity()).build();
    }

    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO) {
        return UserDomain.builder().id(updateUserDTO.getId()).creditCardNumber(updateUserDTO.getCreditCardNumber()).build();
    }


}
