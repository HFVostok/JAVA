package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//ESTABELECER E FECHAR CONEXÃO
public class ConnectionFactory {
    // Atributos de conexão
    private static String URL = "jdbc:postgresql://localhost:5432/postgres"; // URL de conexão com o banco de dados
                                                                             // PostgreSQL.
    private static String USUARIO = "postgres"; // Nome de usuário do banco de dados.
    private static String SENHA = "postgres"; // Senha do banco de dados.
    // Métodos de conexão
    // getConnection

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados.", e);
        }
    }

    // closeConnection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
