import sqlite3

class Database:
    def __init__(self):
        self.db_file = 'mockdb.sqlite'
        self.conn = None

    def db_connection(self):
        try:
            self.conn = sqlite3.connect(self.db_file)
            self.conn.execute("PRAGMA foreign_keys = ON")
        except Exception as e:
            print(f"Connection error: {e}")

    def fetch_record(self, id):
        try:
            with self.conn:
                cur = self.conn.cursor()
                cur.execute("SELECT * FROM users WHERE id = ? LIMIT 1", (id,))
                return cur.fetchone()
        except Exception as e:
            print(f"Error: {e}")
            return None

    def fetch_records(self, id):
        if isinstance(id, int):
            with self.conn:
                cur = self.conn.cursor()
                cur.execute(f"SELECT * FROM users WHERE id = {id}")
                return cur.fetchone()
        return None

    def fetch_recordz(self, id):
        with self.conn:
            cur = self.conn.cursor()
            cur.execute(f"SELECT * FROM users WHERE id = {id}")
            return cur.fetchone()


