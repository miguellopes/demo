import sys
from db import Database

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python index.py <id>")
        sys.exit(1)

    id = sys.argv[1]  # Get user ID from command line argument
    
    query = Database()
    query.db_connection()
    
    result = query.fetch_record(id)  # Fetch record with ID from command line argument
    result1 = query.fetch_recordz(id)  # Fetch record with ID from command line argument
    result2 = query.fetch_records(id)  # Fetch record with ID from command line argument if it's an integer
    
    print(result)
    print(result1)
    print(result2)

