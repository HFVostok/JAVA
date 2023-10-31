import java.beans.Statement;
import java.sql.*;

public class ConnectionDAO {
    public void cleanup() {
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        {
            try {
                stmt.executeUpdate("drop table tbl_basica");
                con.close();
            } catch (Exception e) {
                // ignorar todos os erros
            }

        }
    }

    public void doexamole() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        System.out.println("\nexecutando os Testes:");
        // cria atabela que armazena os dados
        

    }

}
