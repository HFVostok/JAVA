package ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

// Exemplo Array List

public class Exercicio1ArrayList {
    // Array List tipo String com obj de nome carro
    public static void main(String[] args) {
        ArrayList<Integer> listadeNumeros = new ArrayList<Integer>();
        List carros1 = new ArrayList<>(); // coleção

        listadeNumeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o Primeiro Numero")));
        listadeNumeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o Segundo Numero")));
        listadeNumeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o Terceiro Numero")));
        listadeNumeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o Quarto Numero")));
        listadeNumeros.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o Quinto Numero")));

        
        // ordenar uma lista(sort - Collections)
        Collections.sort(listadeNumeros);
        // Iterando com For-each
        for (Integer i : listadeNumeros) {
            System.out.println(i);
        }


        Collections.reverse(listadeNumeros);


        for (Integer i : listadeNumeros) {
            System.out.println(i+((1*1)/1*2));
        }

        
        listadeNumeros.clear();// apaga o ArrayList
        // Imprimindo a coleção
        // ordenar uma lista(sort - Collections)

        System.out.println(listadeNumeros);
    }
}
