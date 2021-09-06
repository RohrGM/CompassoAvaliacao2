<h1 align="center">
    Avaliação 2 Compasso
</h1>

## 📜Sobre

Projeto criado com o intuito de colocar em prática o conteúdo estudado no curso de Java Collections, Spring Boot e Swagger.

## 🚀Tecnologias

O projeto foi desenvolvido com as seguintes tecnologias:

- Java
- JPA
- Spring Boot

## 📌Como utilizar

As atividades 1 e 2 utilizam banco de dados H2, não sendo necessario configurar banco externo. Com a aplicação iniciada o banco sera populado com amostras de testes e possui os seguintes endpoints para cada atividade:

<h1 align="center">
    Atividade 1
</h1>

- # /api/cars:
    - ## get:
        - Filtros:
            - nome: Retorna as entidade por nome
            - marca: Retorna as entidade por marca
            - cor: Retorna as entidades por cor
        - Paginação:
            - page: Retorna as entidades da pagina
            - size: Define o tamanho da pagina
        - Ordenação:
            - sort: Define o critério da ordenação
    - ## post:
        - Parâmetros:
            - nome - Obrigatório
            - regiao - Região valida
            - area
            - populacao
            - capital
            
Exemplo de get utilizando os parâmetros, todos são opcionais.

    http://localhost:8080/api/cars?nome=fiesta&marca=ford&cor=branca&page=0&sort=ano

Exemplo de post:

    http://localhost:8080/api/cars

    Json:
        {
        "chassi":"9BBNSZPPA2880035453",
        "ano":2015,
        "cor":"branca",
        "marca":"ford",
        "nome":"fiesta",
        "valor":20000
        }

<h1 align="center">
    Atividade 2
</h1>

- # /api/states:
    - ## get:
        - Filtros:
            - regiao: Retorna as entidade por região
        - Paginação:
            - page: Retorna as entidades da pagina
            - size: Define o tamanho da pagina
        - Ordenação:
            - sort: Define o critério da ordenação

    - ## get /{id}:
        - Retorna estado por id

    - ## put /{id}:
        - Atualiza estado por id
        - Parâmetros:
            - populacao
            - area

    - ## Delete /{id}:
        - Deleta estado por id
    
    - ## post:
        - Parâmetros:
            - chassi - Obrigatório
            - nome
            - marca
            - cor
            - valor
            - ano
            
Exemplo de get utilizando o parâmetro de região opcional:

    http://localhost:8080/api/states?regiao=sul

Exemplo de get retornando os 3 estados com maior população:

    http://localhost:8080/api/states?size=3&sort=populacao,desc

Exemplo de get retornando os 3 estados com maior área:

    http://localhost:8080/api/states?size=3&sort=area,desc

Exemplo de get e delete por id:

    http://localhost:8080/api/states/1

exemplo de put por id:

    http://localhost:8080/api/states/2?populacao=30000&area=55000.50

Exemplo de post:

    http://localhost:8080/api/states

    Json:
        {
            "populacao":2015,
            "area":2,
            "nome":"sao paulo",
            "regiao":"sudeste",
            "sao paulo":20000
        }



                




Cada uma das atividades está configurada em um workspace diferente.
