Este projeto é uma aplicação simples para realizar operações CRUD (Create, Read, Update, Delete) em um sistema que inicialmente utiliza uma lista em memória para armazenar os dados. 
Depois, a aplicação será expandida para utilizar Hibernate para persistir os dados em um banco de dados relacional.

1. Funcionalidades do CRUD:
POST: Criar um novo item.

GET: Consultar os itens.

PUT: Atualizar os dados de um item existente.

DELETE: Remover um item.

2. Primeira Versão (Sem Persistência com List):
Na primeira versão, os dados serão armazenados em uma lista (em memória), e o CRUD será implementado utilizando um controller que manipula a lista. Não será necessário banco de dados, apenas o comportamento básico de CRUD.

