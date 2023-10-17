public class Task {
    // Atributos
    String description; // Descrição da tarefa
    boolean done; // Indica se a tarefa está concluída (true) ou não (false)

    // Construtor
    public Task(String description) {
        this.description = description; // Inicializa a descrição da tarefa com o valor fornecido
        this.done = false; // Inicializa o status da tarefa como não concluída (false)
    }

    // Métodos Getters e Setters para acessar e modificar os atributos

    public String getDescription() {
        return description; // Retorna a descrição da tarefa
    }

    public void setDescription(String description) {
        this.description = description; // Define a descrição da tarefa com um novo valor
    }

    public boolean isDone() {
        return done; // Retorna o status de conclusão da tarefa
    }

    public void setDone(boolean done) {
        this.done = done; // Define o status de conclusão da tarefa como verdadeiro (true) ou falso
                          // (false)
    }
}
