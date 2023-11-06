package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:postgresql://localhost:5432/legacy";
    private static final String user = "postgres";
    private static final String password = "123456";
    public static Connection conn;

    public static Connection getConexao() throws Exception {
        try {
            if (conn == null){
                conn = DriverManager.getConnection(url,user,password);
                return conn;
            }else {
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
