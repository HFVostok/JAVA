package RevisaoPOO;

import java.util.Scanner;

import RevisaoPOO.Cadastro.Animal;
import RevisaoPOO.Cadastro.Passaros;
import RevisaoPOO.Cadastro.Repteis;
import RevisaoPOO.Cadastro.Roedores;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        // Animal obj = new Animal ("Peixinho",2 , "Gato", "Diogo");
        Passaros contPassaros[] = new Passaros[10];
        Repteis Repteis[] = new Repteis[10];
        Roedores Roedores[] = new Roedores[10];

        Scanner entrada = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1 - Passaros");
            System.out.println("2 - Repteis");
            System.out.println("3 - Roedores");
            System.out.println("4 - Sair");
            opcao = entrada.nextInt();
        } while (opcao != 4);

    }

}