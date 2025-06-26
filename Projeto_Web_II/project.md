#

1.  Definir a entidade do domínio (domain)
2.  Refatorar/definir as relações com a nova entidade de domínio
3.  Definir as regras de negócio - use case
4.  Definir a entidade da infraestrutura (model) - JPA
5.  Refatorar/definir as relações com a nova entidade JPA
6.  Definir o repositório (interface) para a entidade JPA
7.  Definir, se necessário, os métodos no repositório.
8.  Definir o serviço (CRUD)
        Estabelecer os DTOs de entrada e saída
        Definir os conversores: model -> entity; entiy -> dto, ...
9.    Definir o controller/endpoints - utiliza o serviço para enviar requisições (DTOs) e receber respostas (DTOs).
10.    Definir e escrever os testes unitários/integração.
