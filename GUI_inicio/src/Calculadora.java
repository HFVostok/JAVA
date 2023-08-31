import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Calculadora extends JFrame {

    public Calculadora() {
        this.setBounds(200, 200, 400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);
        // for (int i = 1; i <= 10; i++) {
        // JButton but = new JButton("" + i);
        // but.setSize(200, 200);
        // this.add(but);

        // }
 int m = 1;
        for (int i = 0; i <= 4; i++) {
            JPanel painel = new JPanel();
            painel.setSize(400, 100);
            this.setContentPane(painel);
            for (int j = 0; j <= 4; j++) {
                JButton but = new JButton("" + m);
                painel.add(but);
                m++;
            }
        }
        this.setVisible(true);
    }

}