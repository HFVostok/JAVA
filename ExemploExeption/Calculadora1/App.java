package ExemploExeption.Calculadora1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        boolean rodando = true;
        String calc[] = { "Soma", "Subtração", "Multiplicação", "Divisão", "Sair" };

        while (rodando) {
            int opcao = JOptionPane.showOptionDialog(null, "Escolha a Operacão", "Calculadora",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION,
                    null, calc, calc[0]);

            try {

                int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));

                if (opcao == 0) {

                    JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 + numero2));
                } else if (opcao == 1) {
                    JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 - numero2));
                } else if (opcao == 2) {
                    JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 * numero2));
                } else if (opcao == 3) {
                    JOptionPane.showMessageDialog(null, "O resultado é "
                            + (numero1 / numero2));
                } else {
                  rodando = false;

                }

                
            } catch (NumberFormatException erro1) {
                JOptionPane.showMessageDialog(null, "Erro - Valor digitado não é um inteiro");
            } catch (ArithmeticException erro2) {
                JOptionPane.showMessageDialog(null, "Erro Impossivel Dividir por 0");
            } catch (Exception erro3) {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro Favor Desligar");
            }finally {
                JOptionPane.showMessageDialog(null, "\n Digite novamente");
            }
        }
    }
}
