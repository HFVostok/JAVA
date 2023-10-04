import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExemplo {
    public BorderLayoutExemplo() {
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);

        janelaP.add(new JButton("West"), BorderLayout.WEST);
        janelaP.add(new JButton("East"), BorderLayout.EAST);
        janelaP.add(new JButton("Center"), BorderLayout.CENTER);
        janelaP.add(new JButton("North"), BorderLayout.NORTH);
        janelaP.add(new JButton("South"), BorderLayout.SOUTH);

        // set do Frame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
    }
}
