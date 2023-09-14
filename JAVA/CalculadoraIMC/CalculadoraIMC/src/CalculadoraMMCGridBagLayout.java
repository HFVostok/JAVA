// Importes de Recursos do Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculadoraMMCGridBagLayout {
    private JFrame frame;
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton; // cria 
    private JLabel resultLabel;

    // metodo
    public CalculadoraMMCGridBagLayout() {
        frame = new JFrame("Calculadora IMC");  //nome exibido no painel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints ppcimc = new GridBagConstraints();
        ppcimc.gridx = 0;
        ppcimc.gridy = 0;
        ppcimc.fill = GridBagConstraints.HORIZONTAL;
        ppcimc.insets = new Insets(5, 5, 5, 5);

        frame.add(new JLabel("Peso (kg): "), ppcimc);
        ppcimc.gridy++;
        frame.add(new JLabel("Altura (m): "), ppcimc);

        ppcimc.gridx = 1;
        ppcimc.gridy = 0;
        ppcimc.weightx = 1.0;
        ppcimc.fill = GridBagConstraints.HORIZONTAL;
        inputField1 = new JTextField();
        frame.add(inputField1, ppcimc);
        ppcimc.gridy++;
        inputField2 = new JTextField();
        frame.add(inputField2, ppcimc);

        ppcimc.gridx = 0;
        ppcimc.gridy++;
        ppcimc.gridwidth = 2;
        calculateButton = new JButton("Calcular IMC");
        frame.add(calculateButton, ppcimc);

        ppcimc.gridy++;
        ppcimc.gridwidth = 2;
        resultLabel = new JLabel();
        frame.add(resultLabel, ppcimc);

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

            float numero1 = Float.parseFloat(inputField1.getText());
            float numero2 = Float.parseFloat(inputField2.getText());
            float imc = calcularMMC(numero1, numero2);

            resultLabel.setText("O peso: " + numero1 + " e Altura: " + numero2 + " é: " + imc);
        } catch (NumberFormatException e) {
            resultLabel.setText("Digite números válidos.");
        }
    }

    private float calcularMMC(float numero1, float numero2) {

        float imc = numero1 / (numero2 * numero2);

        while (imc % numero1 != 0) {
            imc += numero1;
        }

        return imc;
    }

}
