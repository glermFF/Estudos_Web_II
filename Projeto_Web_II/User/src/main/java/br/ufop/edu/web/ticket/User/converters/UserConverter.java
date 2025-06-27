package br.ufop.edu.web.ticket.User.converters;


import br.ufop.edu.web.ticket.User.domain.UserDomain;
import br.ufop.edu.web.ticket.User.models.UserModel;
import br.ufop.edu.web.ticket.User.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UserRecordDTO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //* Não permite instâncias nos contrutores nesta classe */
public class UserConverter {//* Funciona como o modelo SingleTom */
    
    public static UserRecordDTO toUserRecordDTO(UserModel userModel){ //* Retorna os seguintes dados de usuario */
        return new UserRecordDTO(userModel.getId(), userModel.getName(), userModel.getEmail(), userModel.getCreditCardNetworkModel());
    }

    public static UserModel touUserModel(UserDomain userDomain){
        return UserModel.builder().id(userDomain.getId()).name(userDomain.getName()).creditCardNumber(userDomain.getCreditCardNumber()).email(userDomain.getEmail()).password(userDomain.getPassword()).city(userDomain.getCity()).creditCardNetworkModel(null).build();
    }

    public static UserDomain toUserDomain(CreateUserDTO createUserDTO){
        return UserDomain.builder().name(createUserDTO.getName()).creditCardNumber(createUserDTO.getCreditCardNumber()).email(createUserDTO.getEmail()).password(createUserDTO.getPassword()).city(createUserDTO.getCity()).build();
    }


    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO) { //* Atualiza todos os dados do usuário */
        return UserDomain.builder().id(updateUserDTO.getId()).name(updateUserDTO.getName()).creditCardNumber(updateUserDTO.getCreditCardNumber()).email(updateUserDTO.getEmail()).password(updateUserDTO.getPassword()).city(updateUserDTO.getCity()).build();
    }


}
