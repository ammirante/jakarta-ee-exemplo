# Prova AIS Digital
[![Known Vulnerabilities](https://snyk.io/test/github/ammirante/jakarta-ee-exemplo/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/ammirante/jakarta-ee-exemplo?targetFile=pom.xml) [![Quality Gate Status](http://localhost:9000/api/project_badges/measure?project=jakarta-ee&metric=alert_status)](http://localhost:9000/dashboard?id=jakarta-ee)

<table>
<tr>
<td>
 Desenvolvimento de uma API de filmes e implementação de uma funcionalidade. Para exemplificar o funcionamento, criei um CRUD de filmes.
 Os endpoints disponíveis são:
 
 - GET	/jakarta-ee/api/v1/filmes;
 - GET	/jakarta-ee/api/v1/filmes/{id}
 - POST	/jakarta-ee/api/v1/filmes;
 - DELETE	/jakarta-ee/api/v1/filmes/{id};
 - PUT	/jakarta-ee/api/v1/filmes.
</td>
</tr>
</table>

## Iniciar a aplicação
Para iniciar a aplicação, basta executar o comando: ***mvn clean package payara-micro:start***

Observação importante: como optei por utilizar o banco de dados sqlite3 e não subi o mesmo em um docker, é preciso realizar um ajuste na classe: *PersistenceService* alterando a URL do *datasource* adicionando o arquivo todo.db de acordo com o local que você baixou.
## Sonar
Para executar o sonar, é preciso ter instalado em sua máquina o docker e executar os seguintes comandos:
- Para inicar o sonar: docker-compose -f sonarqube.yml
- Para parar o sonar: docker-compose -f sonarqube.yml down
