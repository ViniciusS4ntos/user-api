# User API 

![Java Version](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=for-the-badge&logo=springboot)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

Microsserviço backend desenvolvido com **Spring Boot** para gerenciamento de usuários, com **autenticação e autorização via JWT**, seguindo boas práticas de **arquitetura em camadas**, **segurança** e **comunicação entre serviços**.

---

## 📋 Sobre o Projeto

A **User API** é um **microsserviço responsável pelo domínio de usuários**, oferecendo funcionalidades de **cadastro, autenticação e gerenciamento**.

O acesso às rotas é protegido por **Spring Security**, sendo necessário realizar login para obter um **token JWT**, que deve ser enviado no header `Authorization` para consumo seguro do microsserviço por outros serviços ou clientes.

Este microsserviço está **concluído** e é utilizado como **serviço base** para outros sistemas, como um **agendador de tarefas**.

---

## 🏗️ Estrutura de Pastas

Arquitetura em camadas para melhor organização e manutenção do microsserviço:



com.vinicius.user_api<br>
│<br>
├── business<br>
│ ├── converter<br>
│ │ └── UsuarioConverter<br>
│ ├── dto<br>
│ │ ├── UsuarioDTO<br>
│ │ ├── EnderecoDTO<br>
│ │ └── TelefoneDTO<br>
│ └── UsuarioService<br>
│<br>
├── controller<br>
│ └── UsuarioController<br>
│<br>
├── infrastructure<br>
│ ├── entity<br>
│ │ ├── Usuario<br>
│ │ ├── Endereco<br>
│ │ └── Telefone<br>
│ │<br>
│ ├── repository<br>
│ │ ├── UsuarioRepository<br>
│ │ ├── EnderecoRepository<br>
│ │ └── TelefoneRepository<br>
│ │<br>
│ ├── exception<br>
│ │ ├── ConflictException<br>
│ │ └── ResourceNotFoundException<br>
│ │<br>
│ └── security<br>
│ ├── JwtRequestFilter<br>
│ ├── JwtUtil<br>
│ ├── SecurityConfig<br>
│ └── UserDetailsServiceImpl<br>
│<br>
└── UserApiApplication<br>

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 4.x**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Spring Data JPA**
* **PostgreSQL**
* **Gradle**
* **Lombok**

---

## 🚀 Como Executar

### Pré-requisitos
* **JDK 17**
* **Gradle**
* **PostgreSQL**

### Passo a passo

```bash
git clone https://github.com/seu-usuario/user-api.git
cd user-api
./gradlew bootRun

A aplicação roda na porta padrão 8080.
É necessário apenas configurar o banco de dados no arquivo application.properties.
```
.

## 🔐 Autenticação e Segurança

Este microsserviço utiliza **JWT** para autenticação.

### Fluxo
1. Login do usuário  
2. Retorno de um **token JWT**  
3. Envio do token no header:

Authorization: Bearer <token>


📌 Todas as rotas protegidas exigem JWT.

---

## 🔗 Endpoints

### Recurso base
/usuario


### ➕ Cadastrar usuário
POST /usuario


### 🔑 Login
POST /usuario/login


### 📄 Buscar usuário por email
GET /usuario?email=usuario@email.com


### ✏️ Atualizar usuário
PUT /usuario


### ❌ Deletar usuário por email
DELETE /usuario/{email}


### 🏠 Endereço
POST /usuario/endereco
PUT /usuario/endereco?id={id}


### 📞 Telefone
POST /usuario/telefone
PUT /usuario/telefone?id={id}


🔐 **Todos os endpoints acima exigem token JWT**, exceto cadastro e login.

---

## ℹ️ Observações

- Microsserviço orientado a domínio
- Segurança com **Spring Security + JWT**
- Uso de **DTOs**
- Validações e regras de negócio
- Tratamento global de exceções

---

## 🎯 Objetivo

- Desenvolver um microsserviço de usuários
- Aplicar **Spring Security e JWT**
- Consolidar arquitetura em camadas

---



