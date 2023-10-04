import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Exercio1 extends JFrame {
    int cliqueConte = 0;

    public Exercio1() {
        super("Exercio 1 Adiçao de Botões");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //this.setBounds(100, 100, 200, 200);
        JButton but = new JButton("Adiona 1 Botão");
        JPanel painel = new JPanel();

        but.addActionListener(e -> {
            cliqueConte++;
            painel.add(but);
            this.getContentPane().add(painel);
            this.setVisible(true);
            this.add(new Button("Botão"));
        });
    }

}
