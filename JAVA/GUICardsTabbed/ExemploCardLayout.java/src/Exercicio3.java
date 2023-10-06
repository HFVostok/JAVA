import javax.swing.*;
import java.awt.*;

public class Exercicio3 extends JFrame {

    public Exercicio3() {
        super("Exercicio 2  - Paginas de Cadastros");
        JPanel painelPrincipal = new JPanel();// Painel Principal dentro do JFrame

        // add painel principal ao JFrame
        this.add(painelPrincipal);

        // criando um botão e um painel de cards
        JButton login = new JButton("Login");// botão de login
        JButton registro = new JButton("Registro");// botão de registro
        JButton principal = new JButton("Menu Principal");// botão de principL

        // criar o objeto do cardLayout
        JPanel cards = new JPanel();// painel de cards no padrão CL
        CardLayout carLay = new CardLayout();
        cards.setLayout(carLay);

        // add o botão e o cards ao painel principal
        painelPrincipal.add(login); // adiciona o Botão de login no painel Principal
        painelPrincipal.add(principal);// adiciona o Botão de principal no painel Principal
        painelPrincipal.add(registro); // adiciona o Botão de registro no painel Principal

        painelPrincipal.add(cards); // Adiciona Cardes

        // criar 3 paineis de cards (cardLogin, cardRegistro, cardPrincipal)
        JPanel cardLogin = new JPanel();
        JPanel cardRegistro = new JPanel();
        JPanel cardPrincipal = new JPanel();

        // add os cardLogin, cardRegistro, cardprincipal ao cards
        cards.add(cardPrincipal, "Card Principal"); // add o card e atribuindo um "nome"
        cards.add(cardLogin, "Card de Login"); // add o card e atribuindo um "nome"
        cards.add(cardRegistro, "Carde de Registro"); // add o card e atribuindo um "nome"

        // diferenciando os cards
        cardPrincipal.add(new TextArea("SEJA BEM VINDO AO SISTEMA ALL DIMENS DE CLASSIFICAÇÃO"));

        cardLogin.add(new JTextField("E-mail", 20));
        cardLogin.add(new JTextField("Senha", 20));
        cardLogin.add(new JButton("Conectar"));

        cardRegistro.add(new JTextField("Nome", 20));
        cardRegistro.add(new JTextField("CPF", 20));
        cardRegistro.add(new JTextField("País", 20));
        cardRegistro.add(new JTextField("Cidade", 20));

        // set do frame
        this.setDefaultCloseOperation(2); // fecha a janela
        this.pack();
        this.setVisible(true);
        // criar o evento para o botão

        login.addActionListener(e -> {
            carLay.show(cards, "Card de Login");
            registro.setVisible(true);
            login.setVisible(false);
            principal.setVisible(true);
            ;

        });

        registro.addActionListener(e -> {
            carLay.show(cards, "Carde de Registro");
            registro.setVisible(false);
            login.setVisible(true);
            principal.setVisible(true);
        });

        principal.addActionListener(e -> {
            carLay.show(cards, "Card Principal");
            registro.setVisible(true);
            login.setVisible(true);
            principal.setVisible(false);
        });

    }
}
