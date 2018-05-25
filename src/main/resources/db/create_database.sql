-- Run this with psql -U YourUser -f create_database.sql
CREATE USER "fp_psp_db" WITH ENCRYPTED PASSWORD 'encomiendas';
ALTER ROLE "encomiendas" WITH createdb;
\c "dbname=postgres user=encomiendas password=encomiendas";
CREATE database "encomiendas";
SELECT datname FROM pg_database WHERE datistemplate = false;