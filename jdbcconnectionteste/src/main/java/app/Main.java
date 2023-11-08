package app;

import Connection.ConnectionDAO;

public class Main {
    public static void main(String[] args) {

        // ConnectionDAO estabelece a conexão
        // new ConnectionDAO().criarTabela();
        // new ConnectionDAO().inserir("Otavio", "otavio@gmail.com");
        // new ConnectionDAO().inserir("OtavioA");
        // new ConnectionDAO().buscarPorId(1);
        // new ConnectionDAO().apagarID(1);
        // new ConnectionDAO().apagarTabela();
        // new ConnectionDAO().atualizarID(2, "João", "João@Gmail.com");
        new ConnectionDAO().listarTodos();
    }
}
