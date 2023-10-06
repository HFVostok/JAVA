<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FlowLayoutExemplo {
    public FlowLayoutExemplo() {
        JFrame frame = new JFrame("Janela");
        JPanel c = new JPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        c.add(new JButton("1"));
        c.add(new JTextField(9));
        c.add(new JButton("dois"));
        c.add(new JButton("três"));
        frame.getContentPane().add(c);
        frame.pack();
        frame.setVisible(true);

    }
}
=======
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FlowLayoutExemplo {
    public FlowLayoutExemplo() {
        JFrame frame = new JFrame("Janela");
        JPanel c = new JPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        c.add(new JButton("1"));
        c.add(new JTextField(9));
        c.add(new JButton("dois"));
        c.add(new JButton("três"));
        frame.getContentPane().add(c);
        frame.pack();
        frame.setVisible(true);

    }
}
>>>>>>> 6bf8ff046210b802fe62b76e7cb2deab4e114eb7
