import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("App");
        setDefaultCloseOperation(2);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro de Usuários", new CadastroUsuario());
        abas.add("Agendamentos do Usúario", new InserirAgendamento());
        add(abas);
    }

    public void run() {
        pack();
        setVisible(true);
    }
}