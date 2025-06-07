package br.ufop.edu.web.ticket.User.services;
import br.ufop.edu.web.ticket.User.converters.UserConverter;
import br.ufop.edu.web.ticket.User.domain.UserDomain;
import br.ufop.edu.web.ticket.User.domain.usecase.CreateUserUsecase;
import br.ufop.edu.web.ticket.User.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UserRecordDTO;
import br.ufop.edu.web.ticket.User.models.UserModel;
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

    public List<UserRecordDTO> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();

        return userModelList.stream().map(UserConverter::toUserRecordDTO).toList(); //* */
    } //* Converte cada elemento da lista (L:20) de UserModel ao UserRecordDTO*/

    public UserRecordDTO createUser(CreateUserDTO createUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        CreateUserUsecase createUserUsecase = new CreateUserUsecase(userDomain);createUserUsecase.validate();

        UserModel userModel = UserConverter.touUserModel(userDomain); //* Recupera os dados por meio do UserModel */

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

    //!! Implementar função semelhante a anterior voltada para a cidade
}
