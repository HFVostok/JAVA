import javax.swing.*;
import java.awt.*;

public class Exercicio5 extends JFrame {
    int pontuacao = 0;
    public Exercicio5() {

        super("Super Quiz");
        CardLayout carLay = new CardLayout();
        JPanel painelPrincipal = new JPanel(carLay);// Painel Principal dentro do JFrame

        // criar Primeiro Card Início
        JPanel primerioCard = new JPanel();
        primerioCard.add(new JLabel("Sejá Bem Vindo ao Jogo"));
        JButton bInicio = new JButton("Start");
        primerioCard.add(bInicio);
        painelPrincipal.add(primerioCard, "Iniciar");
        //
        // criar Primeiro Card Pergunta
        //
        JPanel cPergunta1 = new JPanel();
        cPergunta1.add(new JLabel("Qual o modelo de Foguete em que foi lançado o Sputnik"));
        JTextField rPergunta1 = new JTextField(25);
        JButton bPergunta1 = new JButton("Próxima");
        cPergunta1.add(rPergunta1);
        cPergunta1.add(bPergunta1);
        painelPrincipal.add(cPergunta1, "Pergunta1");
        //
        // criar Segunda Card Pergunta
        //
        JPanel cPergunta2 = new JPanel();
        cPergunta1.add(new JLabel("Nome do Primeiro homem a ir ao Espaço"));
        JTextField rPergunta2 = new JTextField(25);
        JButton bPergunta2 = new JButton("Próxima");
        cPergunta1.add(rPergunta2);
        cPergunta1.add(bPergunta2);
        painelPrincipal.add(cPergunta2, "Pergunta2");
        //
        // criar Terceira Card Pergunta
        //
        JPanel cPergunta3 = new JPanel();
        cPergunta1.add(new JLabel("Qual Pais Pousou a primeira sonda na lua"));
        JTextField rPergunta3 = new JTextField(25);
        JButton bPergunta3 = new JButton("Próxima");
        cPergunta1.add(rPergunta3);
        cPergunta1.add(bPergunta3);
        painelPrincipal.add(cPergunta3, "Pergunta3");
        //
        // criar Quarto Card Pergunta
        //
        JPanel cPergunta4 = new JPanel();
        cPergunta1.add(new JLabel("Quem foi Werner von Brau"));
        JTextField rPergunta4 = new JTextField(25);
        JButton bPergunta4 = new JButton("Próxima");
        cPergunta1.add(rPergunta4);
        cPergunta1.add(bPergunta4);
        painelPrincipal.add(cPergunta4, "Pergunta4");
        //
        // criar Quinta Card Pergunta
        //
        JPanel cPergunta5 = new JPanel();
        cPergunta1.add(new JLabel("Qual das missões americanas Pousaram na Lua"));
        JTextField rPergunta5 = new JTextField(25);
        JButton bPergunta5 = new JButton("Próxima");
        cPergunta1.add(rPergunta5);
        cPergunta1.add(bPergunta5);
        painelPrincipal.add(cPergunta5, "Pergunta5");
        //
        // criar Ultimo Card PResultado
        //
        JPanel cResultado = new JPanel();
        JLabel resultadoFinal = new JLabel();
        cResultado.add(new JLabel("O seu Resultado Foi"));
        cResultado.add(resultadoFinal);
        JButton bNovamente= new JButton("Jogar Novamente");
        cResultado.add(bNovamente);
        painelPrincipal.add(cResultado,"Final");

        // set do frame
        this.add(painelPrincipal);
        this.setDefaultCloseOperation(2); // fecha a janela
        this.pack();
        this.setVisible(true);
        // criar o evento para o botão

        bInicio.addActionListener(e->{
            if(rPergunta1.getText().equals("Brasil")){
                pontuacao+=1;
            }else{
                pontuacao+=2;
            }
            carLay.next(painelPrincipal);
        });

        bPergunta1.addActionListener(e -> {
            carLay.next(painelPrincipal);
        });

        bPergunta2.addActionListener(e -> {
            if(rPergunta2.getText().equals("México")){
                pontuacao+=1;
            }else{
                pontuacao+=2;
            }
            resultadoFinal.setText(" : "+pontuacao);
            carLay.next(painelPrincipal);
        });

        bPergunta3.addActionListener(e -> {
            carLay.next(painelPrincipal);
        });

        bPergunta4.addActionListener(e -> {
            carLay.next(painelPrincipal);
        });

        bPergunta5.addActionListener(e -> {
            carLay.next(painelPrincipal);
        });

        bNovamente.addActionListener(e -> {
            carLay.first(painelPrincipal);
        });

    }
}
