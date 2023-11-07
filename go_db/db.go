package main

import (
	"database/sql"
	"fmt"
	_ "github.com/mattn/go-sqlite3"
	"strconv"
)

type Database struct {
	conn *sql.DB
}

func (db *Database) dbConnection() error {
	var err error
	db.conn, err = sql.Open("sqlite3", "./mockdb.sqlite")
	return err
}

func (db *Database) fetchRecord(id string) {
	stmt, err := db.conn.Prepare("SELECT * FROM users WHERE id = ? LIMIT 1")
	if err != nil {
		fmt.Println(err)
		return
	}
	defer stmt.Close()

	var name, password string
	err = stmt.QueryRow(id).Scan(&id, &name, &password)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Printf("ID: %s, Name: %s,Password: %s\n", id, name, password)
}

func (db *Database) fetchRecordz(id string) {
	rows, err := db.conn.Query("SELECT * FROM users WHERE id = " + id)
	if err != nil {
		fmt.Println(err)
		return
	}
	defer rows.Close()

	for rows.Next() {
		var id, name, password string
		err = rows.Scan(&id, &name, &password)
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Printf("ID: %s, Name: %s,Password: %s \n", id, name, password)
	}
}

func (db *Database) fetchRecords(id string) {
	intID, err := strconv.Atoi(id)
	if err == nil {
		db.fetchRecordz(strconv.Itoa(intID))
	}
}

