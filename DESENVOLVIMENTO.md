# DESENVOLVIMENTO

## Planejamento do Projeto

O projeto foi criado com o objetivo de desenvolver uma aplicação fullstack containerizada com Docker. A arquitetura definida contempla:

- **Frontend**: Interface de usuário responsiva e moderna com ReactJS
- **Backend**: API RESTful construída com Java/Spring
- **Banco de Dados**: PostgreSQL como sistema de banco de dados

---

## Sprints

- **Quantidade de sprints**: 2
- **Duração de cada sprint**: 1 semana

---

## Metodologia Ágil

A metodologia adotada foi o **Scrum**, com as seguintes práticas:

- _Sprint Planning_ para definição de objetivos e escopo da sprint.
- _Daily Stand-ups_ para alinhamento diário da equipe.
- _Sprint Review_ para demonstração e validação das entregas.
- _Sprint Retrospective_ para avaliação contínua e melhoria do processo.

---

## Ferramentas

-  [Trello](trello.com): Gerenciamento de tarefas e acompanhamento do progresso
-  [Docker](https://www.docker.com/): Containerização dos serviços (backend, frontend, banco)
-  [Visual Studio Code](https://code.visualstudio.com/download): Ambiente de desenvolvimento
-  [PostgreSQL](https://www.postgresql.org/): Banco de dados relacional
-  [Git](https://git-scm.com/downloads): Controle de versão

---

## Desafios enfrentados e soluções adotadas

### Configuração do ambiente

- **Problema**: Diferenças entre ambientes dos desenvolvedores
- **Solução**: Uso do Docker para padronizar e simplificar a configuração do ambiente local

### Integração dos serviços

- **Problema**: Comunicação entre backend e banco de dados
- **Solução**: Ajustes nas variáveis de ambiente e na rede do `docker-compose`

### Dependências e inicialização

- **Problema**: Ordem de inicialização dos containers afetava o funcionamento da aplicação
- **Solução**: Definição de `depends_on` no `docker-compose.yml` e uso de `healthchecks`

---