# Projeto Web Services com Spring Boot e JPA/Hibernate


## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para criar a aplicação Java.
- **Java 17**: Linguagem de programação principal.
- **Apache Tomcat**: Servidor de aplicação utilizado para implantar a aplicação Spring Boot.
- **Maven**: Gerenciador de dependências para facilitar a construção e gestão do projeto.
- **Banco de dados H2**: Banco de dados em memória para ambiente de teste.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados em ambiente de produção.
- **Postman**: Ferramenta utilizada para testar e documentar a API RESTful.

<img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/spring.png" width=80 height=70> <img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/postgresql.png" width=100 height=70> <img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/tomcat.png" width=100 height=70> <img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/maven.png" width=130 height=70>
<img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/postman.png" width=100 height=70>
<img src="https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/h2.png" width=100 height=70>

## Funcionalidades Implementadas

1. **Modelo de Domínio com Relacionamentos:**
   - Relacionamentos OneToOne, OneToMany, ManyToOne e ManyToMany implementados.
   - Estrutura de dados bem definida para representar as entidades do domínio.
![Modelo de Domínio](https://github.com/agsa2/webservice-springboot3-jpa/blob/main/img/dominio.png.png)

2. **Estrutura de Camadas Lógicas:**
   - Camadas de recursos (resource), serviço (service) e repositório (repository) implementadas.
   - Organização clara e modular do código para facilitar a manutenção.

3. **Configuração do Banco de Dados de Teste (H2):**
   - Utilização do H2 para ambiente de teste, proporcionando facilidade e agilidade nos testes.
   - Configuração adequada para integração com o Hibernate.

4. **População do Banco de Dados:**
   - Dados de exemplo inseridos no banco de dados para facilitar os testes e demonstrações.

5. **CRUD - Create, Retrieve, Update, Delete:**
   - Implementação das operações básicas de CRUD para manipulação das entidades.

6. **Tratamento de Exceções:**
   - Tratamento de exceções personalizado para melhor gerenciamento de erros.
   - Respostas HTTP adequadas em caso de erros.

## Observações:
   - Certifique-se de ter o Java 17 instalado.
   - A aplicação usa o H2 para teste e o PostgreSQL para produção, certifique-se de configurar corretamente os dados de conexão.


