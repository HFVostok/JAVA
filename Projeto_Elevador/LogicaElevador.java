public class LogicaElevador {

    //private ElevadorModel elevadorModel;

    public String determinarElevador(int valorAndar, int posicaoElevador1, int posicaoElevador2) {

        //elevadorModel = new ElevadorModel();

        // Subtrai o valorAndar das posições dos elevadores
        int diferencaElevador1 = Math.abs(posicaoElevador1 - valorAndar);
        int diferencaElevador2 = Math.abs(posicaoElevador2 - valorAndar);

        // Determina qual elevador está mais próximo do valorAndar
        if (diferencaElevador1 <= diferencaElevador2) {
            // Elevador 1 está mais próximo
            int deslocamentoElevador1 = posicaoElevador1 - valorAndar;
           // elevadorModel.setAndarAtualElevador1(valorAndar);
            return "Elevador 1 vai atuar. Deslocamento: " + deslocamentoElevador1;

        } else {
            // Elevador 2 está mais próximo ou ambos têm a mesma proximidade
            int deslocamentoElevador2 = posicaoElevador2 - valorAndar;
           //elevadorModel.setAndarAtualElevador2(valorAndar);
            return "Elevador 2 vai atuar. Deslocamento: " + deslocamentoElevador2;

        }
    }


}
