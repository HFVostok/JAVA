package ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

// Exemplo Array List

public class ExemploArrayList {
    // Array List tipo String com obj de nome carro
    public static void main(String[] args) {
        ArrayList<String> carros = new ArrayList<String>();
        List carros1 = new ArrayList<>(); // coleção

        carros.add(JOptionPane.showInputDialog("Informe o nome de um carro"));
        carros.add("Monza");
        carros.add("Monza");
        carros.add("MonzA Tubarão");
        carros.add("Brasília");
        carros.add("Chevette");

        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
        // ordenar uma lista(sort - Collections)
        Collections.sort(carros);
        // Iterando com For-each
        for (String i : carros) {
            System.out.println(i);
        }
        carros.clear();// apaga o ArrayList
        // Imprimindo a coleção
        // ordenar uma lista(sort - Collections)
        Collections.reverse(carros);
        System.out.println(carros);
    }
}
