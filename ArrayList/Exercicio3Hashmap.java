package ArrayList;

import java.util.HashMap;

/**
 * Exercicio3Hashmap
 */
public class Exercicio3Hashmap {

    public static void main(String[] args) {
        
        HashMap<String, String> capitaisCidades = new HashMap<>();
        capitaisCidades.put("SP", "São Paulo");

        capitaisCidades.put("RJ", "Rio de Janeiro");

        capitaisCidades.put("MG", "Belo Horizonte");

        capitaisCidades.put("ES", "Vitória");

        capitaisCidades.put("AC", "Rio Branco");

        capitaisCidades.put("PB", "Recífe");
        // Imprime valor correspondente a chave
        System.out.println(capitaisCidades.get("ES"));
        // Imprime chave e valor
        System.out.println(capitaisCidades);
        // Imprime somente chave
        System.out.println(capitaisCidades.keySet());
        // imprimir somente valores
        for (String i : capitaisCidades.keySet()) {
            System.out.println(capitaisCidades.get(i));
        }
    }
}