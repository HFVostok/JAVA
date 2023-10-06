package RevisaoPOO.Cadastro;

public class Passaros extends Animal {
    // Atributos

    String raca;
    String genero;
    Boolean carnivoro;

    // Get e Sters

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

    public Boolean getCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(int i) {
        if (i == 1) {
            this.carnivoro = true;
        } else {
            this.carnivoro = false;
        }
    }

}
