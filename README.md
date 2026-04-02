# 🎬 Screenmatch V3

O Screenmatch V3 é uma aplicação robusta desenvolvida em Spring Boot que atua de forma dupla: como um sistema interativo de linha de comando (CLI) no terminal e como uma **API RESTful** pronta para consumo web. O projeto consome a OMDb API para buscar, salvar e gerenciar dados de séries de TV e episódios, utilizando a inteligência artificial do Google Gemini (`gemini-2.5-flash`) para traduzir as sinopses originais automaticamente para o português.

## 🚀 O que há de novo na V3?
Diferente das versões anteriores, esta versão introduz integrações completas para servir o front-end:
* **Endpoints RESTful**: Exposição inteligente dos dados persistidos no banco de dados, utilizando `DTOs` para entrega padronizada dos JSONs.
* **CORS Habilitado**: Configuração nativa do projeto permitindo chamadas locais de origens externas na porta padrão `http://127.0.0.1:5500`.

## ⚙️ Funcionalidades

### 💻 Menu Interativo (CLI)
Ao executar a aplicação no terminal, você tem um menu interativo com as seguintes operações de gerenciamento:
* **Buscar Séries e Episódios**: Consome e mapeia os dados JSON da API do OMDb diretamente para o banco de dados.
* **Listar Séries e Atores**: Exibe as séries armazenadas, permitindo buscar por trechos de títulos ou nome de atores participantes.
* **Rankings de Avaliação**: Lista o Top 5 das melhores séries e os 5 episódios mais bem avaliados por série.
* **Filtros Específicos**:
    * Busca de séries por Gêneros adaptados para português (Ação, Romance, Comédia, Drama, Crime).
    * Buscas definindo teto máximo de temporadas e notas mínimas de avaliação.
    * Filtro de episódios por trecho do nome ou a partir de um ano de lançamento específico.

### 🌐 Endpoints da API REST
O Controller da aplicação mapeia a rota raiz `/series`, disponibilizando os seguintes endpoints:
* `GET /series`: Retorna todas as séries disponíveis no banco.
* `GET /series/top5`: Retorna a lista com as 5 séries mais bem avaliadas da base.
* `GET /series/lancamentos`: Retorna as séries baseadas nas datas dos episódios mais recentes (lançamentos).
* `GET /series/{id}`: Retorna todos os detalhes mapeados de uma série específica baseando-se no ID.
* `GET /series/{id}/temporadas/todas`: Busca todos os episódios estruturados de todas as temporadas da série.
* `GET /series/{id}/temporadas/{numTemporada}`: Retorna a lista de episódios de uma temporada específica informada na rota.
* `GET /series/categoria/{genero}`: Retorna a lista de séries filtradas por um determinado gênero.

## 🛠️ Tecnologias e Bibliotecas Utilizadas
* **Java 17**
* **Spring Boot** (Incluindo Starters de Web e Data JPA)
* **PostgreSQL** para o banco de dados (Configurado para geração e update automático das tabelas)
* **Maven** para o gerenciamento de builds e dependências
* **Jackson Databind** (v2.15.2) para serialização e manipulação do formato JSON
* **Google GenAI SDK** (v1.43.0) para conexão à inteligência artificial do Google
* **OMDb API** para requisição dos metadados das obras em tempo real

## ⚙️ Configuração e Execução

### Pré-requisitos
* Ter o Java 17 instalado na máquina.
* Ter o banco de dados PostgreSQL instalado, configurado e rodando local ou remotamente.

### Variáveis de Ambiente
Antes de rodar a aplicação, assegure-se de injetar no sistema ou na sua IDE as variáveis de configuração de APIs e de banco de dados:
* `OMDB_API_KEY`: Chave de autenticação adquirida no portal da API OMDb.
* `GEMINI_API_KEY`: Chave de acesso do Google Gemini Studio para tradução de sinopses.
* `DB_HOST`: O host do banco de dados (exemplo: `localhost:5432`).
* `DB_NAME`: Nome da database no PostgreSQL.
* `DB_USER`: Usuário autenticado para transações no banco.
* `DB_PASSWORD`: Senha do banco de dados associada ao usuário.

### Rodando o Projeto
Utilizando um terminal na raiz do projeto, acesse pelo utilitário Maven contido no diretório:

**Em sistemas Linux / macOS:**
\```bash
./mvnw spring-boot:run
\```

**Em sistemas Windows:**
\```cmd
mvnw.cmd spring-boot:run
\```

Após subir, você poderá utilizar imediatamente os comandos interativos em CLI, e sua API ficará disponível em `http://localhost:8080` (porta padrão do Spring Web).