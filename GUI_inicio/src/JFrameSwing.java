

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameSwing extends JFrame {
    public JFrameSwing() {
        super("Minha Primeira Janela JFrame Swing");
        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
