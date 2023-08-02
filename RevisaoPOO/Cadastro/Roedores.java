package RevisaoPOO.Cadastro;

public class Roedores extends Animal {
    String raca;
    String genero;
    boolean castracao;

    // Get e Seters

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isCastracao() {
        return castracao;
    }

    public void setCastracao(int i) {
        if (i == 1) {
            this.castracao = true;
        } else {
            this.castracao = false;
        }
    }

}
