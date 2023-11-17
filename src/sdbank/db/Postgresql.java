package sdbank.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Postgresql {

    private final String url = "jdbc:postgresql://localhost:5432/sdbank";
    private final String usuario = "postgres";
    private final String senha = "fei";
    private Connection conn;

    public Connection connect() throws SQLException{
        try {
            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Server connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 

        return conn;
    }

}
