<h2>Digital Innovation: Cognizant Bootcamp - Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot</h2>

Projeto seguindo as instruções do bootcamp Conginzant - Java developer

Executado no projeto:

* Setup inicial de projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
* Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.
* Desenvolvimento de testes unitários para validação das funcionalidades
* Implantação do sistema na nuvem através do Heroku

Execução do projeto usando o intellij

Caminho para acesso local
```
http://localhost:8080/api/v1/people
```

Foram utilizados no projeto:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Conta no Heroku para o deploy do projeto na nuvem

## Melhorias
Dando sequencia no bootcamp foi apresentado o websecurity do
Spring Boot, assim foi incorporado basicamente os processos
de autenticação e autorização na API, usando JWT.

O usuário está hardcoded como admin com senha admin, e os 
endponints ficaram:
* Teste: 
```
http://localhost:8080/api/v1/people/teste
```
* Login (body com json {userName, password}):
```
http://localhost:8080/api/v1/login
```
* CRUD pessoas (GET, PUT, POST, DELETE)
```
http://localhost:8080/api/v1/people
```
* Referência id pessoa
```
http://localhost:8080/api/v1/people/id
```

## Próximos passos
* gravar no banco de dados as senhas criptografadas.

## Tips
Para conseguir popular a tabela Users com o script 
no arquivo *resources/data.sql* foi necessário incluir a 
seguinte instrução no arquivo *application.properties*.
```
spring.jpa.defer-datasource-initialization=true
```