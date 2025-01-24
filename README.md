# AppClientesBackend

Back-end do meu app de cadastro de clientes, desenvolvido utilizando Spring Boot 3 (Java 17), FlyWay, MapStruct e Lombok. Utiliza banco de dados PostgreSQL 17. 

## Requisitos:
- Java JDK 17</br>
- Spring Tools (em qualquer IDE)</br>
- Banco de dados PostgreSQL 17

## Instalação e configuração do banco de dados PostgreSQL 17
- Instale o docker  
- Inicie o serviço do docker  
Em um terminal, rode os comandos (podem requerir `sudo`):
- `docker pull postgres:17.2`
- `docker run -itd -e POSTGRES_USER=admin -e POSTGRES_PASSWORD='123qwe!@#' -p 5432:5432 -v ./data:/var/lib/postgresql/data --name postgresql postgres`
- `mkdir data`
- `docker exec -it postgresql bash`
- `PGPASSWORD='123qwe!@#' psql -h localhost -p 5432 -U admin`
- `CREATE DATABASE app_clientes OWNER admin;`

## Como rodar o projeto
- Clone o repositório  
- Confira se o container do banco de dados está rodando  
- Abra o projeto na sua IDE com Spring Tools  
- Rode o projeto
<br>

## Modelos de requests para os endpoints da API

### Login:

#### POST Login
`http://localhost:8081/login`  
```json
{   
    "nome": "admin",
    "senha": "123qwe!@#"
}
```
<br>

### * Todos os outros endpoints abaixo requerem configurar a autorização do Postman "Basic Auth" com usuário ('admin' ou 'padrao') e senha da aplicação, ou incluir o seguinte header de autorização no request:
`Authorization: "Basic <token>"`  
  
Onde `<token>` é o token Base64 gerado a partir do nome do usuário e senha.  
<br>
<br>

### Clientes:

#### GET Todos os clientes
`http://localhost:8081/api/clientes`  
<br>

#### GET Cliente por id
`http://localhost:8081/api/clientes/<id>` , `<id>` é o id do cliente  
<br>

#### POST Cliente
`http://localhost:8081/api/clientes`  
```json
{
    "nome": "João",
    "cpf": "01234567890",
    "cep": "76543210",
    "logradouro": "Condomínio de Brasília",
    "bairro": "Jardim Botânico",
    "cidade": "Brasília",
    "uf": "DF",
    "complEndrc": "Número 10"
}
```
<br>

#### PUT Cliente
`http://localhost:8081/api/clientes`  
```json
{
    "id": 1,
    "nome": "João",
    "cpf": "01234567890",
    "cep": "76543210",
    "logradouro": "Condomínio de Brasília",
    "bairro": "Jardim Botânico",
    "cidade": "Brasília",
    "uf": "DF",
    "complEndrc": "Número 10"
}
```
<br>

#### DELETE Cliente
`http://localhost:8081/api/clientes/<id>` , `<id>` é o id do cliente  
<br>
<br>

### Emails:

#### GET Todos os emails
`http://localhost:8081/api/email`
﻿<br>
 
#### GET Email
`http://localhost:8081/api/email/<id>` , `<id>` é o id do email  
<br>

#### POST Email
`http://localhost:8081/api/email`  
```json
{
    "idCliente": 2,
    "endereco": "exemplo@mail.com"
}
```
<br>

#### PUT Email
`http://localhost:8081/api/email`  
```json
{
    "id": 1,
    "idCliente": 2,
    "endereco": "exemplo@mail.com"
}
```
<br>

#### DELETE Email
`http://localhost:8081/api/email/<id>` , `<id>` é o id do email  
<br>
<br>

### Telefones:

#### GET Todos os telefones
`http://localhost:8081/api/telefone`  
﻿<br>
 
#### GET Telefone
`http://localhost:8081/api/telefone/<id>` , `<id>` é o id do telefone    
<br>

#### POST Telefone
`http://localhost:8081/api/telefone`  
```json
{
    "idCliente": 1,
    "numero": "61994223578",
    "tipo": "Celular"
}
```
<br>

#### PUT Telefone
`http://localhost:8081/api/telefone`  
```json
{
    "id": 1,
    "idCliente": 2,
    "numero": "61987654321",
    "tipo": "Celular"
}
```
<br>

#### DELETE Telefone
`http://localhost:8081/api/telefone/<id>` , `<id>` é o id do telefone  

﻿

