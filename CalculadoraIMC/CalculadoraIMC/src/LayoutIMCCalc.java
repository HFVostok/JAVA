
import javax.swing.*;
import java.awt.*;

public class LayoutIMCCalc {
    JButton b1, b2, b3, b4, b5;

    public LayoutIMCCalc() {

        JFrame janelaInicio = new JFrame("Início");
        // GridBagLayout calIMC = new GridBagLayout();
        janelaInicio.setLayout(new GridBagLayout());
        GridBagConstraints imc = new GridBagConstraints();
        imc.insets = new Insets(5, 5, 5, 5); // Distancia entre os botoes ou intens cima,baixo, direta e esquerda

        b1 = new JButton("BOTÃO 1");
        imc.gridx = 0; // Possição Inicial
        imc.gridy = 0; // Posiçaio Inicial
        imc.fill = GridBagConstraints.VERTICAL; // Preenchimento sentido
        imc.gridheight = 5; // Valor do preenchimento
        janelaInicio.add(b1, imc); // Atribui os paramentros ao botão

        b2 = new JButton("BOTÃO 2");
        imc.gridx = 1;
        imc.gridy = 1;
        imc.gridheight = 1;
        janelaInicio.add(b2, imc);

        b3 = new JButton("BOTÃO 3");
        imc.gridx = 2;
        imc.gridy = 2;
        imc.gridheight = 1;
        imc.fill = GridBagConstraints.HORIZONTAL;
        janelaInicio.add(b3, imc);

        b4 = new JButton("BOTÃO 4");
        imc.gridx = 3;
        imc.gridy = 3;
        imc.gridheight = 1;
        janelaInicio.add(b4, imc);

        b5 = new JButton("BOTÃO 5");
        imc.gridx = 1;
        imc.gridy = 4;
        imc.gridwidth = 3;
        janelaInicio.add(b5, imc);

        janelaInicio.setSize(500, 500);
        janelaInicio.setDefaultCloseOperation(2);
        janelaInicio.pack();
        janelaInicio.setVisible(true);

    }

}
