import java.util.ArrayList; // Importa a classe ArrayList para gerenciar uma lista de tarefas
import java.util.List; // Importa a interface List para trabalhar com listas
import java.util.logging.Handler;

import javax.swing.DefaultListModel; // Importa DefaultListModel para usar em uma JList
import javax.swing.JButton; // Importa JButton para criar botões
import javax.swing.JComboBox; // Importa JComboBox para criar uma caixa de seleção
import javax.swing.JFrame; // Importa JFrame para criar a janela principal
import javax.swing.JList; // Importa JList para exibir a lista de tarefas
import javax.swing.JPanel; // Importa JPanel para criar painéis
import javax.swing.JScrollPane; // Importa JScrollPane para adicionar barras de rolagem
import javax.swing.JTextField; // Importa JTextField para criar campo de entrada de texto
import java.awt.*; // Importa classes do pacote awt para gerenciar a interface gráfica

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TodoList extends JFrame {
    // Declaração de atributos
    private JPanel mainPanel; // Painel principal que abriga todos os componentes
    private JTextField taskInputField; // Campo de entrada para adicionar novas tarefas
    private JButton addButton; // Botão para adicionar tarefas
    private JList<String> taskList; // Lista de tarefas exibida na GUI
    private DefaultListModel<String> listModel; // Modelo para a lista de tarefas
    private JButton deleteButton; // Botão para excluir tarefas
    private JButton markDoneButton; // Botão para marcar tarefas como concluídas
    private JComboBox<String> filterComboBox; // ComboBox para filtrar tarefas
    private JButton clearCompletedButton; // Botão para limpar tarefas concluídas
    private List<Task> tasks; // Lista de objetos Task que representam as tarefas

    // Construtor da classe
    public TodoList() {
        // Configuração da Janela Principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        // Inicialização do painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicialização da lista de tarefas e do modelo
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicialização de campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);
        this.setVisible(true);

        // Tratamento de Eventos Hendler's

        Handler1 botaoAdicionar = new Handler1();
        addButton.addActionListener(botaoAdicionar);

        Handler2 botaoDeletar = new Handler2();
        deleteButton.addActionListener(botaoDeletar);

        Handler3 botaoConcluido = new Handler3();
        markDoneButton.addActionListener(botaoConcluido);

        Handler4 caixaDeSelecao = new Handler4();
        filterComboBox.addActionListener(caixaDeSelecao);

        Handler5 limparConteudoLista = new Handler5();
        clearCompletedButton.addActionListener(limparConteudoLista);

        Hendler6 teclaLimparComcluidas = new Hendler6();
        taskList.addKeyListener(teclaLimparComcluidas);

    }

    // Manipulador para Adicionar uma Tarefa
    // ================================================================================================================
    public class Handler1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Adicionar Tarefa
            addTask();
        }
    }

    // Manipulador para Deletar uma Tarefa
    // ===================================================================================================================
    public class Handler2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Deletar Tarefa
            deleteTask();
        }
    }

    // Manipulador para Marcar Tarefa Concluida
    // ===============================================================================================================
    public class Handler3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Marcar Comcluida
            markTaskDone();
        }
    }

    // Manipulador para Filtrar a Tarefa
    // ======================================================================================================================
    public class Handler4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Filtrar Tarefa
            filterTasks();
        }
    }

    // ================================================================================================================
    public class Handler5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Limpar Tarefas Concluidas
            clearCompletedTasks();
        }
    }
    // ================================================================================================================

    public class  Hendler6 implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_K) {
                clearCompletedTasks();
            }
           if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteTask();
            }

        }
    }

    // Métodos para realizar operações CRUD em tarefas (adicionar, excluir, marcar
    // como concluído, filtrar e limpar)

    // Método para adicionar uma nova tarefa
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    // Método para excluir uma tarefa selecionada
    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            tasks.remove(selectedIndex);
            updateTaskList();
        }
    }

    // Método para marcar uma tarefa como concluída
    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    // Método para filtrar tarefas com base na seleção do JComboBox
    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    // Método para limpar tarefas concluídas da lista
    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    // Método para atualizar a lista de tarefas na GUI
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    // Método para exibir a janela
    public void run() {
        this.setVisible(true);
    }
}
