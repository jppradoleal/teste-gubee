# Teste Gubee

Teste para a vaga de BACKEND para a Gubee. Requer a criação de uma API para listagem de serviços oferecidos pela Gubee.
A API deve listar produtos contendo Nome, Descrição, Mercado Alvo e Tecnologias utilizadas.
Além disso, deve ser possível a filtragem de produtos por tecnologia, por exemplo: Se Java 10 e Kafka estiverem sendo filtrados, os produtos mostrados devem implementar as tecnologias Java 10, Kafka, ou Java 10 e Kafka.

## Instruções

Execute os seguintes comandos no terminal.

### Backend
* Acesse a pasta `backend`.
* Execute `./mvnw package`.
* Execute `java -jar target/gubeeapi.jar`.
* Acesse `http://localhost:8080`.

### Frontend
* Acesse a pasta `frontend`.
* Execute `npm install`.
* Execute `npm start`.
* Acesse `http://localhost:4200`

<h2 style="color: red; font-weight: bolder">É importante que as portas 4200 e 8080 estejam desocupadas</h2>

> Vale ressaltar que por motivos de facilidade, a aplicação usa um banco de dados em memória(H2), que tem um problema com encoding. Durante o desenvolvimento foi utilizado um banco Postgres, se preferir, basta comentar as linhas 7 à 10 e descomentar as linhas 1 à 5 no arquivo `src/main/resources/application.properties`. Altere também as credenciais `spring.datasource.username|password`.