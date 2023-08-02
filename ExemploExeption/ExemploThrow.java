package ExemploExeption;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        String senhaPadrao = JOptionPane.showInputDialog("Informe uma Nova Senha com 6 Digitos");
        boolean testeSenha = true;
        while (testeSenha) {

            try {
                String senhaDigitada = JOptionPane.showInputDialog("Informe a Senha com 6 Digitos");

                if (senhaDigitada.length() != 6) {
                    throw new Exception("Senha Invalida");
                }
                testeSenha = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                // TODO: handle exception
            }

        }
    } // Digitação de Senhas

}
