const Database = require('./db.js');

if (process.argv.length !== 3) {
    console.log('Usage: node index.js <id>');
    process.exit(1);
}

const id = process.argv[2];  // Get user ID from command line argument

const query = new Database();
query.dbConnection();

query.fetchRecord(id)  // Fetch record with ID from command line argument
    .then(result => console.log(result))
    .catch(err => console.error(err));

query.fetchRecordz(id)  // Fetch record with ID from command line argument
    .then(result => console.log(result))
    .catch(err => console.error(err));

// Assuming id is a numeric string, otherwise this will throw an error
query.fetchRecords(id)  // Fetch record with ID from command line argument if it's an integer
    .then(result => console.log(result))
    .catch(err => console.error(err));

