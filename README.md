# market-system

Aplicação possui serviço de controle de lançamentos (funcionalidade de criar, listar, editar e excluir lançamentos). Possui também serviço de consolidado diário (funcionalidade de listar os lançamentos por data).

## Ferramentas necessárias para executar aplicação

  - Docker;
  - Docker compose;

## Como executar

1. Navegar até a pasta do projeto /market
2. Rodar comando `sudo docker-compose up`
3. Abrir no browser link do swagger: **http://localhost:8080/swagger-ui/index.html#/**
4. Nesse link do swagger, há todos os endpoints com as funcionalidades


## Observações em relação aos requisitos

Para manter serviço de controle disponível independente do que aconteça com serviço de consolidado diário, seria interessante separa-lós em dois microsserviços distintos, com um circuit breaker fazendo esse gerenciamento para evitar a queda da aplicação como um todo.

Para serviço de consolidado diário manter a carga de requisições pedido, foi colocado um mecanismo de cache, no método **findAllByEntryDate()**.

O diagrama da solução na pasta resources, mostra uma visão to-be, como pensei se fosse realmente algo para produção.
