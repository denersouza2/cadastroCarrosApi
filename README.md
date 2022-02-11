# cadastroCarrosApi
API Spring de cadastro de carros com autenticação stateless via JWt e Spring Security.

## Login

> URI: api/carro/save

> PARAM: {username,password}

> METHOD: POST

> HEADERS:



## Salvar

> URI: api/carro/save

> PARAM: {descricao,ano}

> METHOD: POST

> HEADERS: Authorization



## Deletar carro por id

> URI: api/carro/delete/{id}

> PARAM: 

> METHOD: DELETE

> HEADERS: Authorization



## Listar carros cadastrados

> URI: api/carro/getAll

> PARAM: 

> METHOD: GET

> HEADERS: Authorization



## Buscar carros por id
 
> URI: api/carro/getById/{id}

>PARAM: 

> METHOD: GET

> HEADERS: Authorization


## Atualizar carro por id

> URI: api/carro/update/{id}

> PARAM: {descricao,ano}

> METHOD: PUT

> HEADERS: Authorization
