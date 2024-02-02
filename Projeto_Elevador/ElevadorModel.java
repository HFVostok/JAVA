public class ElevadorModel {

    private int andarAtualElevador1;
    private int andarAtualElevador2;
    private int valorAndar;

     public ElevadorModel() {
         this.andarAtualElevador1 = 0;
         this.andarAtualElevador2 = 0;
         this.valorAndar = 0;
     }

    public ElevadorModel(int andarAtualElevador1, int andarAtualElevador2, int valorAndar) {
        this.andarAtualElevador1 = andarAtualElevador1;
        this.andarAtualElevador2 = andarAtualElevador2;
        this.valorAndar = valorAndar;
    }

    public int getAndarAtualElevador1() {
        return andarAtualElevador1;
    }

    public void setAndarAtualElevador1(int andarAtualElevador1) {
        this.andarAtualElevador1 = andarAtualElevador1;
    }

    public int getAndarAtualElevador2() {
        return andarAtualElevador2;
    }

    public void setAndarAtualElevador2(int andarAtualElevador2) {
        this.andarAtualElevador2 = andarAtualElevador2;
    }

    public int getValorAndar() {
        return valorAndar;
    }

    public void setValorAndar(int valorAndar) {
        this.valorAndar = valorAndar;
    }

}
