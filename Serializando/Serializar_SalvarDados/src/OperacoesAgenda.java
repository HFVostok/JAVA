import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacoesAgenda {

    private List<AgendamentoUsuario> agendamento;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public OperacoesAgenda(List<AgendamentoUsuario> agendamento) {
        this.agendamento = agendamento;
        this.tableModel = tableModel;
        this.table = table;
    }

    public void cadastrarAgenda(String usuario, String data, String hora, String descricao, String prioridade) {
        OperacoesAgenda agenda = new agenda(usuario, data, hora, descricao, prioridade);
        agendamento.add(agenda);
        atualizarTabela();
    }

    public void atualizarAgenda(int linhaSelecionada, String usuario, String data, String hora, String descricao, String prioridade) {
        if (linhaSelecionada != -1) {
            OperacoesAgenda agenda = new agenda (usuario, data, hora, descricao, prioridade);
            agendamento.set(linhaSelecionada, agenda);
            atualizarTabela();
        }
    }

    public void apagarApagar(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendamento.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    // public void salvarAgendas() {
    // Serializacao.serializar("dados.txt", agendamento);
    // }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (OperacoesAgenda agenda : agendamento) {
            tableModel.addRow(new Object[] { agenda.getUsuario(), agenda.getData(), agenda.getHora(),
                    agenda.getDescricao(), agenda.getPrioridade()});
        }
    }

}