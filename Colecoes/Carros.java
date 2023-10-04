package Colecoes;

import javax.swing.JOptionPane;

public class Carros {
    /**
     * Carros
     */
    // atributos

    String marca;
    String modelo;
    String ano;
    String cor;
    String placa;

    public Carros(String marca, String modelo, String ano, String cor, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // metodo proprio

    //ImprimirLN

    public String imprimirLN() // listar
    {

        String imprimir = marca + " " + modelo + " " + ano + " " + cor + "" + placa + "\n";
        return imprimir;
    }

    public void imprimir() {
        JOptionPane.showMessageDialog(null, marca + " " + modelo + " " + ano + " " + cor + "" + placa + "\n");
    }

}
