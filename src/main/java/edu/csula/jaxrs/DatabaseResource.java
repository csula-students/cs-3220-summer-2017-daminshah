package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseResource {
    public static final String database = "cs3220xstu18";
    public static final String url = "jdbc:mysql://cs3.calstatela.edu/" + database;
    public static final String username = "cs3220xstu18";
    public static final String password = "kUzxf.f!";

    public DatabaseResource() {
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