package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Model.Clientes;

public class ClientesControl {

    // atributos
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodosCL();
        // Obtém os carros atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(),

                    cliente.getTelefone(), cliente.getCpf(), cliente.getIdade() });
        }
    }

    public void cadastrar(String nome, String endereco, String telefone, String cpf, String idadeStr) {
        try {
            // Verifica se o nome é nulo ou vazio
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Preencha o Campo: Nome");
            }

            // Verifica se o endereco é nulo ou vazio
            if (endereco == null || endereco.isEmpty()) {
                throw new IllegalArgumentException("Preencha o Campo: Endereço");
            }

            // Verifica se o telefone é nulo ou vazio
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Preencha o Campo: Telefone");
            }

            // Verifica se o cpf é nulo ou vazio
            if (cpf == null || cpf.isEmpty()) {
                throw new IllegalArgumentException("Preencha o Campo: CPF");
            }

            // Verifica se a idade não é vazia e é um número
            if (idadeStr == null || idadeStr.isEmpty()) {
                throw new IllegalArgumentException("Preencha o Campo: Idade");
            }
            int idade = Integer.parseInt(idadeStr);

            // Agora você pode prosseguir com a lógica de cadastro no banco de dados
            // Exemplo: new ClientesDAO().cadastrar(nome, endereco, telefone, cpf, idade);

        } catch (NumberFormatException e) {
            // Tratamento de exceção para conversão de String para int
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro: Idade deve ser um número válido.");
        } catch (IllegalArgumentException e) {
            // Tratamento de exceção para outras validações
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro: " + e.getMessage());
        } catch (Exception e) {
            // Tratamento de exceção, se necessário
            JOptionPane.showMessageDialog(null, "Erro durante o cadastro: " + e.getMessage());
        } finally {
            // Atualiza a tabela de exibição após o cadastro, mesmo que haja uma exceção
            atualizarTabela();
        }
    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String nome, String endereco, int telefone, String cpf, int idade) {
        new ClientesDAO().atualizaCL(nome, endereco, telefone, cpf, idade);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String cpf) {
        new ClientesDAO().apagarCL(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}