import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevadorGUI extends JFrame {
    private ElevadorModel elevadorModel;
    private LogicaElevador logicaElevador;

    public ElevadorGUI() {
        setTitle("Controle de Elevadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 4));

        elevadorModel = new ElevadorModel(0,0,0);

        JTextField nomeElevador1 = new JTextField("Elevador 1");
        nomeElevador1.setEditable(false);

        JTextField nomeElevador2 = new JTextField("Elevador 2");
        nomeElevador2.setEditable(false);

        JTextField painelElevador = new JTextField("Painel");
        painelElevador.setEditable(false);

        JPanel elevador1Panel = criarPainelElevador("Elevador 1");
        add(new JScrollPane(elevador1Panel));

        JPanel colunaEsquerda = new JPanel();
        add(colunaEsquerda);

        JPanel elevador2Panel = criarPainelElevador("Elevador 2");
        add(new JScrollPane(elevador2Panel));

        JPanel colunaMeio = new JPanel();
        add(colunaMeio);

        JPanel colunaBotoes = new JPanel(new GridLayout(9, 1));
        for (int i = 6; i >= 1; i--) {
            JButton button = new JButton("Botão " + i);
            button.addActionListener(new ElevadorActionListener("Elevador 1", i));
            colunaBotoes.add(button);
        }

        JButton ELTerreo = new JButton("Térreo");
        ELTerreo.addActionListener(new ElevadorActionListener("Elevador 1", 0));

        JButton ELSubsolo1 = new JButton("Subsolo 1");
        ELSubsolo1.addActionListener(new ElevadorActionListener("Elevador 1", -1));

        JButton ELSubsolo2 = new JButton("Subsolo 2");
        ELSubsolo2.addActionListener(new ElevadorActionListener("Elevador 1", -2));

        colunaBotoes.add(ELTerreo);
        colunaBotoes.add(ELSubsolo1);
        colunaBotoes.add(ELSubsolo2);

        add(new JScrollPane(colunaBotoes));

        setSize(1200, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Adicione uma mensagem inicial indicando o estado inicial dos elevadores
        JOptionPane.showMessageDialog(null,
                "Estado inicial:\nElevador 1 no andar " + elevadorModel.getAndarAtualElevador1()
                        + "\nElevador 2 no andar " + elevadorModel.getAndarAtualElevador2());
    }

    private JPanel criarPainelElevador(String nomeElevador) {
        logicaElevador = new LogicaElevador();
        JPanel elevadorPanel = new JPanel(new GridLayout(13, 1));

        JTextField nomeElevadorField = new JTextField(nomeElevador);
        nomeElevadorField.setEditable(false);
        elevadorPanel.add(nomeElevadorField);

        for (int i = 6; i >= 1; i--) {
            JTextField button = new JTextField("N° " + i);
            button.addActionListener(new ElevadorActionListener(nomeElevador, i));
            elevadorPanel.add(button);
        }

        JTextField ELTerreo = new JTextField("Térreo");
        ELTerreo.addActionListener(new ElevadorActionListener(nomeElevador, 0));
        JTextField ELSubsolo1 = new JTextField("Subsolo 1");
        ELSubsolo1.addActionListener(new ElevadorActionListener(nomeElevador, -1));
        JTextField ELSubsolo2 = new JTextField("Subsolo 2");
        ELSubsolo2.addActionListener(new ElevadorActionListener(nomeElevador, -2));

        elevadorPanel.add(ELTerreo);
        elevadorPanel.add(ELSubsolo1);
        elevadorPanel.add(ELSubsolo2);

        return elevadorPanel;
    }

    private class ElevadorActionListener implements ActionListener {
        private int valorAndar;

        public ElevadorActionListener(String nomeElevador, int valorAndar) {
            this.valorAndar = valorAndar;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            elevadorModel.setValorAndar(valorAndar);

            LogicaElevador logicaElevador = new LogicaElevador();
            String decisao = logicaElevador.determinarElevador(valorAndar, elevadorModel.getAndarAtualElevador1(),
                    elevadorModel.getAndarAtualElevador2());

            String mensagem = "Elevador em deslocamento:\n" + decisao + "\nAndar atual: " + valorAndar;
            JOptionPane.showMessageDialog(null, mensagem);

            // Atualiza os valores de posição no modelrAno
            elevadorModel.setAndarAtualElevador1(valorAndar);
            elevadorModel.setAndarAtualElevador2(valorAndar);
        }
    }

}
