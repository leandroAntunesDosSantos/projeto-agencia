package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/legacy";
    private static final String user = "root";
    private static final String password = "123456";
    public static Connection conn;

    public static Connection getConexao() throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");
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
