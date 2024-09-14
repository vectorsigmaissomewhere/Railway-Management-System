import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_DB {
    static final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";  
    static final String PASS = "admin";  

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {

                // SQL query to create a database
                String sql = "CREATE DATABASE RAILWAY";
                stmt.executeUpdate(sql);  // Execute the SQL query
                System.out.println("Database created successfully.");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
