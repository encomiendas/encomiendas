-- Run this with psql
CREATE USER "encomiendas" WITH ENCRYPTED PASSWORD 'encomiendas';
ALTER ROLE "encomiendas" WITH createdb;

CREATE DATABASE encomiendas
  WITH OWNER = encomiendas
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_PY.UTF-8'
       LC_CTYPE = 'es_PY.UTF-8'
       CONNECTION LIMIT = -1;