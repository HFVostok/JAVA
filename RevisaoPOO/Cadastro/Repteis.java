package RevisaoPOO.Cadastro;

public class Repteis extends Animal {
    String raca;
    String genero;
    boolean sencibilidadeLuz;

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

    public boolean getSencibilidadeLuz() {
        return sencibilidadeLuz;
    }

    public void setSencibilidadeLuz(int i) {
        if (i == 1) {
            this.sencibilidadeLuz = true;
        } else {
            this.sencibilidadeLuz = false;
        }
    }

}
