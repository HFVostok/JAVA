package ArrayList;

import java.util.HashMap;

public class Exerciocio3bHashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> nomeIdade = new HashMap<>();

        nomeIdade.put("Theodosio", 6);
        nomeIdade.put("Aghata", 8);
        nomeIdade.put("Lemão", 19);
        
        System.out.println(nomeIdade.get("Aghata"));
    }
}
