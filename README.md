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
