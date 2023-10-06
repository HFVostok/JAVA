<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
//import java;

public class GridLayout {

    public GridLayout() {
        JFrame frame = new JFrame("Swing Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel c = new JPanel();
        frame.getContentPane().add(c);
     //   c.setLayout(new GridLayout(2, 2));
        c.add(new JButton("um"));
        c.add(new JTextField(5));
        c.add(new JButton("dois"));
        c.add(new JButton("três"));
        frame.setVisible(true);
        frame.pack();

    }
}
=======
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
//import java;

public class GridLayout {

    public GridLayout() {
        JFrame frame = new JFrame("Swing Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel c = new JPanel();
        frame.getContentPane().add(c);
     //   c.setLayout(new GridLayout(2, 2));
        c.add(new JButton("um"));
        c.add(new JTextField(5));
        c.add(new JButton("dois"));
        c.add(new JButton("três"));
        frame.setVisible(true);
        frame.pack();

    }
}
>>>>>>> 6bf8ff046210b802fe62b76e7cb2deab4e114eb7
