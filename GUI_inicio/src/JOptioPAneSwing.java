import javax.swing.JOptionPane;

public class JOptioPAneSwing extends JOptionPane {

    public JOptioPAneSwing() {
        String Informacao = "Minha Janela JOption";
        JOptionPane.showMessageDialog(getComponentPopupMenu(), Informacao, Informacao, JOptionPane.INFORMATION_MESSAGE);

    }
}
