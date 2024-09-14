package RailwayManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private String user = "user";
	private String pass = "#1#2#3%1%2%3";
	private String url = "jdbc:mysql://localhost/railway management system";
	private Statement statement;
	
	public Database() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, pass);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY);
	}
	
	public Statement getStatement() {
		return statement;
	}

}
