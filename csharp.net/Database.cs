using System;
using System.Data;
using Dapper;
using System.Data.SQLite;
using System.Threading.Tasks;

public class Database
{
    private string db_file = "mockdb.sqlite";
    
    public IDbConnection DbConnection()
    {
        return new SQLiteConnection($"Data Source={db_file};Version=3;");
    }

    public async Task<dynamic> FetchRecordAsync(string id)
    {
        using (var db = DbConnection())
        {
            return await db.QueryFirstOrDefaultAsync("SELECT * FROM users WHERE id = @Id LIMIT 1", new { Id = int.Parse(id) });
        }
    }

    public async Task<dynamic> FetchRecordsAsync(string id)
    {
        int parsedId;
        if (!int.TryParse(id, out parsedId)) return null;

        using (var db = DbConnection())
        {
            return await db.QueryFirstOrDefaultAsync("SELECT * FROM users WHERE id = @Id", new { Id = parsedId });
        }
    }

    public async Task<dynamic> FetchRecordzAsync(string id)
    {
        using (var db = DbConnection())
        {
            return await db.QueryFirstOrDefaultAsync($"SELECT * FROM users WHERE id = {id}");
        }
    }
}

