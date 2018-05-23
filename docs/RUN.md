## Ejecutar el servidor 
El servidor PSP utiliza un sistema de compilación basado en Maven y liquibase para la evolución de la base de datos. También utiliza Spring Boot para ejecutar el JAR compilado con un servidor Tomcat integrado.

## Pre-requisitos

* Maven 3.3.9 or above
* Java 8
* PostgreSQL 9.4 or above

## Configuración básica

Estos son pasos que solo necesitará realizar la primera vez que lo haga
configurando el servidor.

### Paso 0, clonar el repositorio

```shell
git clone https://github.com/domainsoft/encomiendas.git
```
### Paso 1, crear la base de datos

Run with psql the script:

```shell
psql -U YOUR_USER_HERE -f src/main/resources/db/create_database.sql
```

Yo can also copy and paste the following snippet to your favorite PSQL client:

```
CREATE USER "encomiendas" WITH ENCRYPTED PASSWORD 'encomiendas';
ALTER ROLE "encomiendas" WITH createdb;
\c "dbname=postgres user=encomiendas password=encomiendas";
CREATE database "encomiendas";
SELECT datname FROM pg_database WHERE datistemplate = false;
```

Esto generará la base de datos inicial, y a partir de este punto cualquier cambio relacionado con la base de datos será a través de [Liquibase] (LIQUIBASE.md).

Liquibase runs automatically during server startup and update the DB (if 
needed).

### Paso 2, compilar la aplicación

From the encomiendas directory, run:

```shell
mvn clean install -DskipTests
```

### Paso 3, ejecutas la aplicación

Start the server:

```shell
java -jar target/encomiendas-0.0.1-SNAPSHOT.war
```

Y eso es todo, su servidor se iniciará de forma predeterminada en http://localhost:8080

## ¿Qué sigue?

En desarrollo

