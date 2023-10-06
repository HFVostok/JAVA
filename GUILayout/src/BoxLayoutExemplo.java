<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;

public class BoxLayoutExemplo extends JFrame {
    public BoxLayoutExemplo() {

        // confirmando layout do frame

        super("Exemplo Box Layout");
        BorderLayout border = new BorderLayout();
        this.setLayout(border);

        // cria dois paineis

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();

        // adiciona os paineis ao frame

        this.add(painel1, BorderLayout.WEST);
        this.add(painel2, BorderLayout.SOUTH);

        // layout dos paineis
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));

        // adiciona elementos ao Painel

        for (int i = 0; i < 5; i++) {
            painel1.add(new JButton("" + i + 1));
            painel2.add(new JButton("" + i + 1));
        }
        // set do frame

        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}
=======
import javax.swing.*;
import java.awt.*;

public class BoxLayoutExemplo extends JFrame {
    public BoxLayoutExemplo() {

        // confirmando layout do frame

        super("Exemplo Box Layout");
        BorderLayout border = new BorderLayout();
        this.setLayout(border);

        // cria dois paineis

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();

        // adiciona os paineis ao frame

        this.add(painel1, BorderLayout.WEST);
        this.add(painel2, BorderLayout.SOUTH);

        // layout dos paineis
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));

        // adiciona elementos ao Painel

        for (int i = 0; i < 5; i++) {
            painel1.add(new JButton("" + i + 1));
            painel2.add(new JButton("" + i + 1));
        }
        // set do frame

        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);
    }
}
>>>>>>> 6bf8ff046210b802fe62b76e7cb2deab4e114eb7
