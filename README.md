# BookAPI
API de biblioteca feita em Java com Spring Boot

## Instalação

Faça o clone do repositório:

```Ruby
  git clone https://github.com/matheusnascimentods/ManagementAPI.git
```

Entre na pasta do repositório
```Ruby
  cd bookapi/target
```

Antes de rodar o projeto crie uma banco de dados MySQL assim como o de `application.properties` e cole no terminal 
```Ruby
  java -jar api.jar
```

## Endpoints

##### Endpoints da entidade livros
`GET` Consultar todos os livros
```Ruby
 http://localhost:8080/book
```

`GET` Consultar livro pelo id
```Ruby
 http://localhost:8080/book/{id}
```

`POST` Cadastrar livro
```Ruby
 http://localhost:8080/book
```
```Ruby
{
    "title": "",
    "description": "",
    "pages": 0,
    "chapters": 0,
    "authorId": 0,
    "publisherId": 0 
}
```

`DELETE` Excluir livro
```Ruby
 http://localhost:8080/book/{id}
```

`PUT` Atualizar livro
```Ruby
 http://localhost:8080/book/{id}
```
```Ruby
{
    "title": "",
    "description": "",
    "pages": 0,
    "chapters": 0,
    "authorId": 0,
    "publisherId": 0 
}
```

##### Endpoints da entidade autores
`GET` Consultar todos os autores
```Ruby
 http://localhost:8080/author
```

`GET` Consultar autor pelo id
```Ruby
 http://localhost:8080/author/{id}
```

`POST` Cadastrar autor
```Ruby
 http://localhost:8080/author
```
```Ruby
{
    "name": "",
    "age": 0 
}
```

`DELETE` Excluir autor
```Ruby
 http://localhost:8080/author/{id}
```

##### Endpoints da entidade editoras
`GET` Consultar todas as editoras
```Ruby
 http://localhost:8080/publisher
```

`GET` Consultar editora pelo id
```Ruby
 http://localhost:8080/publisher/{id}
```

`POST` Cadastrar editora
```Ruby
 http://localhost:8080/publisher
```
```Ruby
{
    "name": ""
}
```

`DELETE` Excluir editora
```Ruby
 http://localhost:8080/publisher/{id}
```
