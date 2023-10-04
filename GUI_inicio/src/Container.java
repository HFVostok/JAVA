import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Container extends JFrame {

    public Container() {
        this.setBounds(100, 50, 500, 235);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        this.setLayout(flow);
        for (int i = 1; i <= 10; i++) {
            this.add(new JButton("Aperte" + i));
            this.setVisible(true); // Exibe a Tela
        }
        JLabel label = new JLabel("Test 1");
        
       // box.add(label);

        JTextField campo = new JTextField(15);

       // Window.pack();

    }
}
