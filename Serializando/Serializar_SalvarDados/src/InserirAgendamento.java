import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InserirAgendamento extends JPanel {
    private JTextField inputUsuario;
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputDescricao;
    private JTextField inputPrioridade;

    private DefaultTableModel tableModel;
    private JTable table;

    private List<AgendamentoUsuario> agenda = new ArrayList<>();
    private int linhaSelecionada = -1;

    public InserirAgendamento() {

        // set do Frame

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Usuário");
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Prioridade");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // barra de rolagem

        /// declaração dos Componentes

        inputUsuario = new JTextField(20);
        inputData = new JTextField(5);
        inputHora = new JTextField(5);
        inputDescricao = new JTextField(5);
        inputPrioridade = new JTextField(5);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();

        inputPanel.add(new JLabel("Usúario"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(new JLabel("Prioridade:"));
        inputPanel.add(inputPrioridade);

        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);

        // set do Layout

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            agenda = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputUsuario.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputDescricao.setText((String) table.getValueAt(linhaSelecionada, 3));
                    inputPrioridade.setText((String) table.getValueAt(linhaSelecionada, 4));


                }
            }
        });
        OperacoesAgenda operacoes = new OperacoesAgenda(usuarios, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarAgenda(inputUsuario.getText(), inputData.getText(), inputHora.getText(),inputDescricao.getText(),inputPrioridade.getText());
                inputUsuario.setText("");
                inputData.setText("");
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputUsuario.getText(),

                        inputData.getText());

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosUsuarios();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (AgendamentoUsuario agenda : agenda) {
            //tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }
}
