<pre><?php
require_once 'db.php';



$query = new Database();
$result = $query->fetchRecord($_GET['id']);  // Fetch record with ID 1
$result1 = $query->fetchRecordz($_GET['id']);  // Fetch record with ID 1
$result2 = $query->fetchRecords($_GET['id']);  // Fetch record with ID 1
print_r($result);
print_r($result1);
print_r($result2);

