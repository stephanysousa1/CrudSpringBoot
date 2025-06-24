

## Projeto CRUD de Clientes – Spring Boot

**Descrição geral:**
Este projeto é uma API RESTful completa para o gerenciamento de clientes, desenvolvida utilizando o Spring Boot. Ele implementa as operações fundamentais de um CRUD (Create, Read, Update, Delete), permitindo a criação, leitura, atualização e exclusão de registros de clientes de forma eficiente. A persistência dos dados é garantida através do Hibernate e Spring Data JPA, com um banco de dados MySQL como backend.
## Funcionalidades

* **POST /clientes**
  Cria um novo cliente no sistema.

* **GET /clientes/{id}**
  Retorna todos os clientes cadastrados e tambem filtra pelo ID.

* **PUT /clientes/{id}**
  Atualiza os dados de um cliente existente (identificado pelo ID).

* **DELETE /clientes/{id}**
  Remove um cliente do sistema (identificado pelo ID).

---

### Tecnologias Utilizadas

* **Java ☕** : Linguagem de programação principal, na versão 17+.
* **Spring Boot 🌱** : Framework líder para desenvolvimento rápido e simplificado de aplicações Java, focado em microserviços e APIs RESTful.
* **Spring Data JPA** : Facilita enormemente o acesso a dados, fornecendo uma camada de abstração poderosa sobre JPA
* **MySQL** : Sistema de Gerenciamento de Banco de Dados Relacional (SGBDR)
* **Hibernate 🧑‍💻**: A implementação padrão da JPA, responsável pelo Mapeamento Objeto-Relacional (ORM)
* **Maven** : Ferramenta padrão para automação de build e gerenciamento de dependências do projeto Java
* **Bean Validation** : API utilizada para validar a integridade e consistência dos dados de entrada (JSON) recebidos pela API antes que sejam processados
* **Postman** : Ferramenta de desenvolvimento para testar e interagir com os endpoints da API.
* **Lombok** : Biblioteca que reduz a verbosidade do código Java


Qualquer dúvida ou sugestão de melhoria, me avise!
