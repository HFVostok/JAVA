import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CalculadoraGUI {

    public CalculadoraGUI() {

        // Layout Calcuçadora
        BorderLayout border = new BorderLayout();
        
        JFrame janelaP = new JFrame("Layout Calculadora");
        // Mudando Layout da Frame
        JPanel painelB = new JPanel();// Padrão Flowlayout
        JPanel painelV = new JPanel();// Padrão Flowlayout

        janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
        janelaP.getContentPane().add(painelV, BorderLayout.NORTH);

        // Adicionar o TextFild no Painel

        JTextField = new JTextField(25);

        painelV.add(caixa1);

        janelaP.setLayout(border);
        // Set Layout do Jpanel
        GridLayout grid = new GridLayout(4, 4);
        BorderLayout border = new BorderLayout();
        painelB.setLayout(grid);

        // janelaP.add(new JButton("North"), BorderLayout.NORTH);
        // Vetor Com os Testos Dos Botões
        String textbotoes[] = { "C", "9", "8", "7", "/", "6", "5", "4", "*", "3", "2", "1", "-", "+", "0", "=" };
        for (int i = 0; i < textbotoes.length; i++) {
            painelB.add(new JButton(textbotoes[i]));

        }
        // set do Frame
        janelaP.setDefaultCloseOperation(2);
        janelaP.pack();
        janelaP.setVisible(true);
    }

}