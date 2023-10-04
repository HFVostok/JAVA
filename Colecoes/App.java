    package Colecoes;

import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // Cadastrar Novo Carro
        // Consultar Carros
        // Excluir Carros da Minha Lista

        List<Carros> listaCarros = new ArrayList<>();
        boolean iniciado = true;
        String consultaVeiculos = "";
        String opcao[] = { "1 - Cadastrar Novo Veiculo", "2 - Consultar", "3 - Excluir Veiculo", "4 - Sair" };

        while (iniciado) {
            int selecao = JOptionPane.showOptionDialog(null, "Esolha a Seguintes Opções:", "Loja Carro Universo",
                    JOptionPane.DEFAULT_OPTION, 1, null, opcao, opcao[0]);
            if (selecao == 0) {
                // Lista de opções
                Carros cars = new Carros(JOptionPane.showInputDialog("Informe a Marca do Veiculo"),
                        JOptionPane.showInputDialog("Informe o Modelo do Veiculo"),
                        JOptionPane.showInputDialog("Informe o Ano"),
                        JOptionPane.showInputDialog("cor"),
                        JOptionPane.showInputDialog("Placa"));

                // adiciona as informações obtidas no objeto cars da list carros
                listaCarros.add(cars);
            } else if (selecao == 1) {

                /*
                 * opçao de listagem com resumo
                 * int i = 0;
                 * for (Carros carros : listaCarros) {
                 * consultaVeiculos += i + carros.imprimirLN();
                 * i++;
                 * }
                 * int acao2=Integer.parseInt(
                 * JOptionPane.showInputDialog(
                 * "Escolah o Carro:\n"+consultaVeiculos));
                 * listaCarros.get(acao2).imprimir();
                 */
                for (Carros a : listaCarros) {
                    consultaVeiculos += a.getMarca() + "\n" + a.getModelo() + "\n" + a.getAno() + "\n" + a.getCor()
                            + "\n" + a.getPlaca();
                }
                JOptionPane.showMessageDialog(null, consultaVeiculos);

            } else if (selecao == 2) {

                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i +"-"+ carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Escolah o Carro Para Excluir:\n" + "" + listar));
                listaCarros.get(acao2).imprimir();
                listaCarros.remove(acao2);
            } else {
                iniciado = false;
            }
        }
    }
}
