<?php
class Database {

	private $db_file = __DIR__ . '/mockdb.sqlite';
	public $conn;

	public function dbConnection() {
		$this->conn = null;
		try {
			$this->conn = new PDO("sqlite:" . $this->db_file);
			$this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		} catch(PDOException $exception) {
			echo "Connection error: " . $exception->getMessage();
		}
		return $this->conn;
	}


	public function fetchRecord($id) {
		$db = $this->dbConnection();
		$stmt = $db->prepare("SELECT * FROM users WHERE id = :id LIMIT 1");
		$stmt->bindParam(':id', $id, PDO::PARAM_INT);
		$stmt->execute();
		return $stmt->fetch(PDO::FETCH_ASSOC);
	}
	public function fetchRecords($id) {
		$db = $this->dbConnection();
		if(is_int($id)) {
			$stmt = $db->prepare("SELECT * FROM users WHERE id = ".$id);
			$stmt->execute();
			return $stmt->fetch(PDO::FETCH_ASSOC);
		}
	}
	public function fetchRecordz($id) {
		$db = $this->dbConnection();
		$stmt = $db->prepare("SELECT * FROM users WHERE id = ".$id);
		$stmt->execute();
		return $stmt->fetch(PDO::FETCH_ASSOC);
	}
}
