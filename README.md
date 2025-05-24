Projeto com Frontend, Backend e Banco de dados PostgreSQL integrados em Docker.

# Instalação e Execução

## 1. Certifique-se que o git está instalado
- Abra o terminal e digite `git --version`
   se já estiver instalado, siga para o próximo passo, caso não:
  ## Windows
  você pode baixar e instalar o git [Aqui](https://git-scm.com/downloads/win)
  ## Linux
  Ubuntu/Debian
   - ``sudo apt install git``

  Fedora
   - ``sudo dnf install git``

  Arch
   - ``sudo pacman -S git``


## 2. Certifique também que o docker esteja instalado
   - Abra o terminal e digite `docker --version`
   se já estiver instalado, siga os próximos passos, caso não, siga as instruções abaixo
## Windows
caso esteja no windows, Acesse o site do [Docker](https://www.docker.com/get-started/) e instale o **Docker Desktop**.

## Linux/etc
Acesse o site de [Documentação do docker](https://docs.docker.com/engine/install/) para instalar no seu sistema operacional respectivo

## 3. Clone o Repositório
      git clone https://github.com/CapnArrys/projeto-fullstack-docker.git

## 4. Entre na pasta do projeto
      cd projeto-fullstack-docker/

## 5. Rode o projeto no Docker
      docker compose up --build

após isso, os containers do frontend, backend e banco de dados deverão estar rodando no Docker, digite `docker ps` no terminal para certificar que os containers estão rodando, com isso o projeto foi executado com sucesso.
