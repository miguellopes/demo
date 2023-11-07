package main

import (
	"fmt"
	"os"
)

func main() {
	arg := os.Args[1]
	db := Database{}
	err := db.dbConnection()
	if err != nil {
		fmt.Println(err)
		return
	}
	defer db.conn.Close()

	db.fetchRecord(arg)
	db.fetchRecordz(arg)
	db.fetchRecords(arg)
}

