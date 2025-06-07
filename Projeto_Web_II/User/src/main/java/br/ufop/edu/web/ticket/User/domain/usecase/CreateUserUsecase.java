package br.ufop.edu.web.ticket.User.domain.usecase;

import br.ufop.edu.web.ticket.User.domain.UserDomain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserUsecase {
    
    UserDomain userDomain;

    public void validate(){
        //*  Regras de negócio da aplicação
        validateName();

    }

    private void validateName(){
        if(this.userDomain.getName() == null){
            throw new RuntimeException("Onde está o nome?");
        }
    }
}
