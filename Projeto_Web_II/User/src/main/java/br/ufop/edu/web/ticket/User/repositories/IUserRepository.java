package br.ufop.edu.web.ticket.User.repositories;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufop.edu.web.ticket.User.models.UserModel;


public interface IUserRepository extends JpaRepository<UserModel, UUID>{ //* Extende de JpaRepository construindo o modelo UserModel com prikey UUID */
    
    List<UserModel> findByName(String name);
    List<UserModel> findByCity(String city);

    List<UserModel> findAllByNameContainingIgnoreCase(String name); //* Permite consultas ao banco de dados com multiplos argumentos */

    //!! Implementar um retorno com a cidade
}
