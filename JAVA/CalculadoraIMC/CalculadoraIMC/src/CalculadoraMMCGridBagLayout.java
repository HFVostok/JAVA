import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraMMCGridBagLayout {
    private JFrame frame;
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton;
    private JLabel resultLabel;

    public CalculadoraMMCGridBagLayout() {
        frame = new JFrame("Calculadora IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        frame.add(new JLabel("Número 1:"), gbc);
        gbc.gridy++;
        frame.add(new JLabel("Número 2:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputField1 = new JTextField();
        frame.add(inputField1, gbc);
        gbc.gridy++;
        inputField2 = new JTextField();
        frame.add(inputField2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        calculateButton = new JButton("Calcular IMC");
        frame.add(calculateButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        resultLabel = new JLabel();
        frame.add(resultLabel, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMMC();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void calcularMMC() {
        try {
            int numero1 = Integer.parseInt(inputField1.getText());
            int numero2 = Integer.parseInt(inputField2.getText());

            int mmc = calcularMMC(numero1, numero2);

            resultLabel.setText("O IMC de " + numero1 + " e " + numero2 + " é: " + mmc);
        } catch (NumberFormatException e) {
            resultLabel.setText("Digite números válidos.");
        }
    }

    private int calcularMMC(int numero1, int numero2) {
        int maximo = Math.max(numero1, numero2);
        int minimo = Math.min(numero1, numero2);
        int mmc = maximo;

        while (mmc % minimo != 0) {
            mmc += maximo;
        }

        return mmc;
    }


}
