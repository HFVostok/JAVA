package RevisaoPOO;

import java.util.Scanner;

import javax.swing.JOptionPane;

import RevisaoPOO.Cadastro.Animal;
import RevisaoPOO.Cadastro.Passaros;
import RevisaoPOO.Cadastro.Repteis;
import RevisaoPOO.Cadastro.Roedores;
import RevisaoPOO.Agenda.Agenda;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        // Animal obj = new Animal ("Peixinho",2 , "Gato", "Diogo");
        // cria o cadastro
        Passaros Passaros[] = new Passaros[10];
        Repteis Repteis[] = new Repteis[10];
        Roedores Roedores[] = new Roedores[10];
        Agenda Agenda[] = new Agenda[100];
        Scanner entrada = new Scanner(System.in);

        int contPassaros = 0;
        int contRepteis = 0;
        int contRoedores = 0;

        // criar aplicação

        JOptionPane.showMessageDialog(null, "Benvindo a Bioclin - Modifica Geneticas e Tratamentos");

        boolean aberto = true;

        while (aberto) {
            // opções de entrada 1,2,3.
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consuta\n 3-Sair"));
            // se opção 1
            if (acao1 == 1) { // cadastro

                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Passaro\n 2-Repteis\n 3-Roedores"));

                if (acao2 == 1) {
                    // cria um objeto tipo 1
                    Passaros[contPassaros] = new Passaros();
                    Passaros[contPassaros].setCarnivoro(JOptionPane.showConfirmDialog(null, "ELE É CARNIVORO?",
                            "POR FAVOR ESCOLHA SIM/NÃO", JOptionPane.YES_NO_OPTION));
                    Passaros[contPassaros].setEspecie(JOptionPane.showInputDialog("A ESPECIE:"));
                    Passaros[contPassaros].setGenero(JOptionPane.showInputDialog("O GENERO:"));
                    Passaros[contPassaros].setNome(JOptionPane.showInputDialog("NOME:"));
                    Passaros[contPassaros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("PESO:")));
                    Passaros[contPassaros].setProprietario(JOptionPane.showInputDialog("NOME DO PROPRIETARIO:"));
                    Passaros[contPassaros].setRaca(JOptionPane.showInputDialog("DIGITE A RAÇA:"));
                    contPassaros++;

                } else if (acao2 == 2) {
                    // cria um objeto tipo 2
                    Repteis[contRepteis] = new Repteis();
                    Repteis[contRepteis].setEspecie(JOptionPane.showInputDialog("A ESPECIE:"));
                    Repteis[contRepteis].setGenero(JOptionPane.showInputDialog("O GENERO:"));
                    Repteis[contRepteis].setNome(JOptionPane.showInputDialog("NOME:"));
                    Repteis[contRepteis].setPeso(Double.parseDouble(JOptionPane.showInputDialog("PESO:")));
                    Repteis[contRepteis].setProprietario(JOptionPane.showInputDialog("NOME DO PROPRIETARIO:"));
                    Repteis[contRepteis].setRaca(JOptionPane.showInputDialog("DIGITE A RAÇA:"));
                    Repteis[contRepteis]
                            .setSencibilidadeLuz(JOptionPane.showConfirmDialog(null, "ELE POSSUÍ SENCIBILIDADE A LUZ?",
                                    "POR FAVOR ESCOLHA SIM/NÃO", JOptionPane.YES_NO_OPTION));
                } else if (acao2 == 3) {
                    // cria um objeto tipo 3
                    Roedores[contRoedores] = new Roedores();
                    Roedores[contRoedores].setCastracao(JOptionPane.showConfirmDialog(null, "ELE É CASTRADO?",
                            "POR FAVOR ESCOLHA SIM/NÃO", JOptionPane.YES_NO_OPTION));
                    Roedores[contRoedores].setEspecie(JOptionPane.showInputDialog("A ESPECIE:"));
                    Roedores[contRoedores].setGenero(JOptionPane.showInputDialog("O GENERO:"));
                    Roedores[contRoedores].setNome(JOptionPane.showInputDialog("NOME:"));
                    Roedores[contRoedores].setPeso(Double.parseDouble(JOptionPane.showInputDialog("PESO:")));
                    Roedores[contRoedores].setProprietario(JOptionPane.showInputDialog("NOME DO PROPRIETARIO:"));
                    Roedores[contRoedores].setRaca(JOptionPane.showInputDialog("DIGITE A RAÇA:"));

                    // se opção 2

                } else if (acao1 == 2) {

                }
            }

        }

    }
}
