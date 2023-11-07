const sqlite3 = require('sqlite3').verbose();

class Database {
    constructor() {
        this.db = null;
    }

    dbConnection() {
        this.db = new sqlite3.Database('./mockdb.sqlite', (err) => {
            if (err) {
                console.error(err.message);
                throw err;
            }
        });
    }

    fetchRecord(id) {
        return new Promise((resolve, reject) => {
            this.db.get("SELECT * FROM users WHERE id = ? LIMIT 1", [id], (err, row) => {
                if (err) {
                    reject(err.message);
                } else {
                    resolve(row);
                }
            });
        });
    }

    fetchRecordz(id) {
        return new Promise((resolve, reject) => {
            this.db.get(`SELECT * FROM users WHERE id = ${id}`, (err, row) => {
                if (err) {
                    reject(err.message);
                } else {
                    resolve(row);
                }
            });
        });
    }

    fetchRecords(id) {
        return new Promise((resolve, reject) => {
            if (Number.isInteger(id)) {
                this.db.get(`SELECT * FROM users WHERE id = ${id}`, (err, row) => {
                    if (err) {
                        reject(err.message);
                    } else {
                        resolve(row);
                    }
                });
            } else {
                resolve(null);
            }
        });
    }
}

module.exports = Database;

