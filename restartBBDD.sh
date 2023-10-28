#!/bin/bash

echo "Reiniciando tablas de la Base de Datos."

cd ./musclegymBD

service postgresql restart

psql < login.sql
psql < loginInsert.sql
psql < noticias.sql
psql < noticiasInsert.sql
psql < reservas.sql
psql < reservasInsert.sql

echo "Tablas reiniciadas."
