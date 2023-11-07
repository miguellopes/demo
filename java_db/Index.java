import java.sql.*;
import java.io.StringWriter;
import java.io.PrintWriter;

public class Index {
    public static void main(String[] args) {
        Database query = new Database();
        try {
            ResultSet result1 = query.fetchRecordz(args[0]); // Fetch record with ID passed as argument
            ResultSet result = query.fetchRecord(args[0]); // Fetch record with ID passed as argument
            ResultSet result2 = query.fetchRecords(args[0]); // Fetch record with ID passed as argument
            printResult(result1);
            printResult(result);
            printResult(result2);
        } catch (Exception e) {
    StringWriter sw = new StringWriter();
    e.printStackTrace(new PrintWriter(sw));
    String exceptionAsString = sw.toString();
    System.out.println(exceptionAsString);
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printResult(ResultSet result) throws SQLException {
        while (result.next()) {
            System.out.println("ID: " + result.getInt("id") + ", Username: " + result.getString("username") + ", Password: " + result.getString("password"));
        }
    }
}

