package lab6;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Database {
	
	
	public static final String database = "cs3220xstu18";
    public static final String url = "jdbc:mysql://cs3.calstatela.edu/" + database;
    public static final String username = "cs3220xstu18";
    public static final String password = "kUzxf.f!";
    
    
    
    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch( ClassNotFoundException e ) {
            throw new IllegalStateException(e);
        }
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
