using System;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        Database query = new Database();
        var result1 = await query.FetchRecordzAsync(args[0]);  // Fetch record with ID passed as argument
        Console.WriteLine(result1);
        var result = await query.FetchRecordAsync(args[0]);  // Fetch record with ID passed as argument
        var result2 = await query.FetchRecordsAsync(args[0]);  // Fetch record with ID passed as argument

        Console.WriteLine(result);
        Console.WriteLine(result2);
    }
}

