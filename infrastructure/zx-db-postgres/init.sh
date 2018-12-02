#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE ROLE zxdbuser WITH LOGIN PASSWORD 'P@ssp0rt';
    CREATE DATABASE zxdb;
    GRANT ALL PRIVILEGES ON DATABASE zxdb TO zxdbuser;
EOSQL