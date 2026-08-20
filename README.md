# Workshop MongoDB

API REST desenvolvida em Java com Spring Boot e MongoDB para demonstrar o uso de um banco de dados orientado a documentos em uma aplicação web.

O projeto trabalha com usuários, posts e comentários, incluindo relacionamentos entre documentos, consultas por título e autor, busca completa por texto e filtros por período. Ele também apresenta uma organização básica em camadas, com controllers, services, repositories, DTOs e tratamento de exceções.

## Tecnologias

- Java 25
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data MongoDB
- MongoDB
- Maven Wrapper

## Pré-requisitos

- Java 25 instalado e configurado no `PATH`;
- MongoDB em execução localmente na porta `27017`;
- Git, caso queira clonar o projeto.

Por padrão, a aplicação utiliza a seguinte conexão:

```properties
mongodb://localhost:27017/workshop_mongo
```

Essa configuração está em `src/main/resources/application.properties` e pode ser alterada conforme o ambiente.

## Como executar

Clone o repositório e entre na pasta do projeto:

```bash
git clone https://github.com/Daniel-Brevess/workshop_mongodb.git
cd workshop_mongodb
```

Inicie a aplicação com o Maven Wrapper:

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

## Atenção aos dados de exemplo

Durante a inicialização, a classe `Instantiation` remove os usuários e posts existentes e insere dados de exemplo. Portanto, os dados locais são recriados sempre que a aplicação é iniciada e os IDs gerados podem mudar.

## Endpoints

### Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/users/FindAll` | Lista todos os usuários |
| GET | `/users/{id}` | Busca um usuário pelo ID |
| POST | `/users/insert` | Cria um novo usuário |
| PUT | `/users/{id}` | Atualiza nome e e-mail de um usuário |
| DELETE | `/users/{id}` | Remove um usuário |
| GET | `/users/{id}/posts` | Lista os posts de um usuário |

Exemplo de criação:

```http
POST /users/insert
Content-Type: application/json
```

```json
{
  "name": "Mariane Cocozuda",
  "email": "mariane.cocozuda@gmail.com"
}
```

Exemplo de atualização:

```http
PUT /users/ID_DO_USUARIO
Content-Type: application/json
```

```json
{
  "name": "Bob o pedreiro",
  "email": "bobpedreiro@gmail.com"
}
```

### Posts e buscas

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/posts/{id}` | Busca um post pelo ID |
| GET | `/posts/titlesearch?text=...` | Busca posts pelo título |
| GET | `/posts/authorsearch?text=...` | Busca posts pelo autor |
| GET | `/posts/fullsearch?text=...&minDate=yyyy-MM-dd&maxDate=yyyy-MM-dd` | Busca por texto e intervalo de datas |

Para parâmetros com espaços ou caracteres especiais, use URL encoding. Por exemplo:

```text
/posts/titlesearch?text=construir%20casa
```

## Respostas de erro

Quando um usuário ou post não é encontrado, a aplicação lança uma exceção de domínio e retorna `404 Not Found` com informações sobre o horário, status, mensagem e caminho solicitado.

## Estrutura principal

```text
src/main/java/org/danielbreves/workshopmongo
├── config          # carga dos dados iniciais
├── domain          # entidades User e Post
├── dto             # objetos de transferência
├── repository      # interfaces do Spring Data MongoDB
├── resources       # controllers e tratamento HTTP
└── service         # regras de negócio
```

## Testes e build

Para compilar o projeto:

```bash
./mvnw clean package
```

No Windows:

```powershell
.\mvnw.cmd clean package
```

Para executar os testes:

```bash
./mvnw test
```

## Licença

Este projeto foi desenvolvido para fins de estudo e prática com Spring Boot, Spring Data MongoDB e APIs REST.
