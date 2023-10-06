<<<<<<< HEAD
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ContainerComponetes extends JFrame {
    // atributo

    int cliqueConte = 0;

    public ContainerComponetes() {
        super("JFrame");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I am a Swing button");
        JLabel texto = new JLabel("Number of button clicks: ");
        JPanel painel = new JPanel();
        painel.add(but);
        painel.add(texto);
        this.getContentPane().add(painel);
        this.pack();
        this.setVisible(true);
        but.addActionListener(e -> {
            cliqueConte++;

            texto.setText("Número de Cliques" +cliqueConte);

        });

    }
}
=======
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ContainerComponetes extends JFrame {
    // atributo

    int cliqueConte = 0;

    public ContainerComponetes() {
        super("JFrame");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I am a Swing button");
        JLabel texto = new JLabel("Number of button clicks: ");
        JPanel painel = new JPanel();
        painel.add(but);
        painel.add(texto);
        this.getContentPane().add(painel);
        this.pack();
        this.setVisible(true);
        but.addActionListener(e -> {
            cliqueConte++;

            texto.setText("Número de Cliques" +cliqueConte);

        });

    }
}
>>>>>>> 6bf8ff046210b802fe62b76e7cb2deab4e114eb7
