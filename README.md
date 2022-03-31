# Exemplo de implementação do Circuitbreak
### O serviço de Produto irá fazer uma requisição no serviço de Avaliação

## Tecnologias
### Resilience4j
### RestTemplate
### Postgres

## Urls
### http://localhost:8080/avaliacoes
### http://localhost:8080/avaliacoes/produtoId/{produtoId)
### http://localhost:8090/produtos/{produtoId)
### http://localhost:8090/produtos

## Base de Dados
### docker run --name cb-postgres -e POSTGRES_DB=circuitbreak -e POSTGRES_PASSWORD=cb123 -p 5432:5432 -d postgres
