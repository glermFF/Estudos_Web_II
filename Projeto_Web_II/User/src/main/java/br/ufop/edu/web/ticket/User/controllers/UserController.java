package br.ufop.edu.web.ticket.User.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import br.ufop.edu.web.ticket.User.dtos.CreateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserDTO;
import br.ufop.edu.web.ticket.User.dtos.UpdateUserPasswordDTO;
import br.ufop.edu.web.ticket.User.dtos.UserRecordDTO;
import br.ufop.edu.web.ticket.User.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController //*Indica que a classe comportará como dispositivo de controle */
@AllArgsConstructor
@RequestMapping("/users") //*Habilitar depois */
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> getState() {
        return ResponseEntity.ok("EndPoint on PORT 3000");
    }
    
    @GetMapping
    public ResponseEntity <List<UserRecordDTO>> getAllUsers() { //* Mapeia e retorna todos os usuários no endpoint /users */

        List<UserRecordDTO> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){ //* Método com generics, usado momentaneamente para retornar os usuários */
        return ResponseEntity.ok("Service is running"); //* Indicador de que o servidor está rodando */ 
    }

    @PostMapping 
    public ResponseEntity<UserRecordDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserRecordDTO userRecordDTO =  userService.createUser(createUserDTO);
        return ResponseEntity.ok(userRecordDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecordDTO> getUserById(@PathVariable(value = "id")String id){ //* Lista os usuários pelo respectivo ID */
        UserRecordDTO userRecord = userService.getUserById(id);

        if(userRecord == null){
            return ResponseEntity.notFound().build(); //* Retorna mensagem de erro em situação que o id não é retornado */
        }

        return ResponseEntity.ok(userRecord);
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity <List<UserRecordDTO>> getUserByName(@PathVariable(value = "name")String name){

        List<UserRecordDTO> username = userService.getUserByName(name);
        return ResponseEntity.ok(username);
    }

    @GetMapping("/bycity/{city}")
    public ResponseEntity <List<UserRecordDTO>> getUserByCity(@PathVariable(value = "city")String city){
        return null; //!! Alterar e retornar de acordo com a cidade
    }

    @PutMapping
    public ResponseEntity<UserRecordDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO){

        UserRecordDTO userRecordDTO = userService.updateUser(updateUserDTO);

        if (userRecordDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecordDTO);
    }

    @PutMapping("/password") //* Entendendo mudança de apenas um campos do usuário */
    public ResponseEntity<UserRecordDTO> updateUserPassword(@RequestBody UpdateUserPasswordDTO updateUserPasswordDTO){

        UserRecordDTO userRecordDTO = userService.updatePassword(updateUserPasswordDTO);

        if (userRecordDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecordDTO);
    }
}
