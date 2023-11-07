#!/bin/bash

# Name of the database file
DB_FILE="mockdb.sqlite"

# SQL commands to create table and insert data
SQL_COMMANDS="
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL,
    password TEXT NOT NULL
);

INSERT INTO users (username, password) VALUES ('testuser1', 'password1');
INSERT INTO users (username, password) VALUES ('testuser2', 'password2');
INSERT INTO users (username, password) VALUES ('testuser3', 'password3');
"

# Execute SQL commands to create the database, table, and insert data
echo "$SQL_COMMANDS" | sqlite3 $DB_FILE

# Check if the database file was created and the table was populated
if [[ -f $DB_FILE ]]; then
    echo "Database file $DB_FILE created successfully."
    echo "Table 'users' and mock data inserted successfully."
else
    echo "Failed to create database file $DB_FILE."
fi

