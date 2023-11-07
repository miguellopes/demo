import java.sql.*;

public class Database {

    private String dbFile = "mockdb.sqlite";
    private Connection conn;

    public Connection dbConnection() {
        try {
            // Load the SQLite JDBC driver (if it's not already loaded)
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return this.conn;
    }

    public ResultSet fetchRecord(String id) throws SQLException {
	    Connection db = dbConnection();
	    PreparedStatement stmt = db.prepareStatement("SELECT * FROM users WHERE id = ? LIMIT 1");
	    try{
		    stmt.setInt(1, Integer.parseInt(id));
		    return stmt.executeQuery();
	    } catch (Exception e) {
		    return null;
	    }
    }

    public ResultSet fetchRecords(String id) throws SQLException {
        Connection db = dbConnection();
        if (isInt(id)) {
            Statement stmt = db.createStatement();
            return stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
        } else {
		return null;
        }
    }

    public ResultSet fetchRecordz(String id) throws SQLException {
        Connection db = dbConnection();
        Statement stmt = db.createStatement();
        return stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

