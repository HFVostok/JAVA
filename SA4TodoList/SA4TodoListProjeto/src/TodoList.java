import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoList extends JFrame {
    // Declaração de atributos
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private JButton trashButton; // Botão para excluir uma tarefa para a lixeira
    private List<Task> tasks;
    private List<Task> trashBin = new ArrayList<>(); // Lista para manter tarefas na lixeira
    private JButton trashFileButton;

    public TodoList() {
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas", "Lixeira" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        trashButton = new JButton("Lixeira"); // Novo botão "Lixeira"
        trashFileButton = new JButton("Arquivo Lixeira");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.add(trashButton); // Adicionar o botão "Lixeira" ao painel de botões
        buttonPanel.add(trashFileButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);

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

        Handler6 teclasDeAtalho = new Handler6();
        taskInputField.addKeyListener(teclasDeAtalho);
        taskList.addKeyListener(teclasDeAtalho);

        Handler7 mouseClickListener = new Handler7();
        taskList.addMouseListener(mouseClickListener);

        Handler8 filtroCombox = new Handler8();
        filterComboBox.addActionListener(filtroCombox);

        Handler9 botaoLixeira = new Handler9();
        trashButton.addActionListener(botaoLixeira);

        Handler10 botaoArquivoLixeira = new Handler10();
        trashFileButton.addActionListener(botaoArquivoLixeira);
    }

    // Manipulador para Adicionar uma Tarefa
    // ===================================================================================================================
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
            int escolha = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir essa tarefa?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION) {
                System.out.println("Você escolheu 'Sim'.");
                deleteTask();
            } else if (escolha == JOptionPane.NO_OPTION) {
                System.out.println("Você escolheu 'Não'.");

            } else {
                System.out.println("A janela foi fechada sem escolha.");
                // Trate o caso em que o usuário fechou a janela sem fazer uma escolha
            }
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
    // Manipulador para Filtrar a Tarefa
    public class Handler4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtém a opção selecionada no JComboBox
            String filter = (String) filterComboBox.getSelectedItem();

            if (filter.equals("Lixeira")) {
                // Se a opção for "Lixeira", exibe as tarefas na lixeira
                showTrashBin();
            } else {
                // Caso contrário, filtra as tarefas com base na seleção
                filterTasks(filter);
            }
        }
    }

    // Método para filtrar tarefas com base na seleção do JComboBox
    private void filterTasks(String filter) {
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone())
                    || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
            }
        }
    }

    // Manipulador para limpar Tarefa Completas
    // ================================================================================================================
    public class Handler5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Limpar Tarefas Concluidas
            clearCompletedTasks();
        }
    }
    // Manipulador para Teclas de Atalho
    // ================================================================================================================

    public class Handler6 implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_K) {
                clearCompletedTasks(); // Limpar Tarefas Completas Com K
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                addTask(); // Add Tarefas com Enter
            }

            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                // deletar tarefas com Delete e Caixa de Confirmação
                int escolha = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir essa tarefa?",
                        "Confirmação", JOptionPane.YES_NO_OPTION);
                if (escolha == JOptionPane.YES_OPTION) {
                    System.out.println("Você escolheu 'Sim'.");
                    deleteTask();
                } else if (escolha == JOptionPane.NO_OPTION) {
                    System.out.println("Você escolheu 'Não'.");

                } else {
                    System.out.println("A janela foi fechada sem escolha.");
                    // Trate o caso em que o usuário fechou a janela sem fazer uma escolha
                }
            }

        }
    }

    // Manipulador para Tarefas Excluir Completas
    // ================================================================================================================
    public class Handler7 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                deleteTask();
            }
        }
    }

    // Manipulador para o Filtro
    // ================================================================================================================
    public class Handler8 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Chama Classe Para Adicionar Tarefa
            filterTasks();
        }
    }

    // Manipulador para o botão "Lixeira"
    // ================================================================================================================
    public class Handler9 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtém os índices das tarefas selecionadas na lista
            int[] selectedIndices = taskList.getSelectedIndices();

            // Verifica se há tarefas selecionadas
            if (selectedIndices.length > 0) {
                int escolha = JOptionPane.showConfirmDialog(null,
                        "Você deseja mover as tarefas selecionadas para a lixeira aperte Yes, Excluir permanetemente Aperte NO?",
                        "Escolha uma ação", JOptionPane.YES_NO_CANCEL_OPTION);

                if (escolha == JOptionPane.YES_OPTION) {
                    // Mover as tarefas selecionadas para a lixeira (ou qualquer outra ação
                    // desejada)
                    moveTasksToTrash(selectedIndices);
                } else if (escolha == JOptionPane.NO_OPTION) {
                    // Excluir permanentemente as tarefas selecionadas
                    deleteSelectedTasks(selectedIndices);
                } else {
                    // Cancelar a ação
                    System.out.println("Ação cancelada.");
                }

                // Atualiza a lista de tarefas após a ação
                updateTaskList();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma tarefa selecionada para mover para a lixeira.", "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public class Handler10 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showTrashBin();
        }
    }
    // ================================================================================================================
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
                listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
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

    // Método para mover para a Lixeira
    // ================================================================================================================================================
    private void moveTasksToTrash(int[] selectedIndices) {
        for (int index : selectedIndices) {
            if (index >= 0 && index < tasks.size()) {
                Task taskToMove = tasks.get(index);
                trashBin.add(taskToMove);
                tasks.remove(index);
            }
        }
        JOptionPane.showMessageDialog(null, "Tarefas movidas para a lixeira.", "Ação concluída",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteSelectedTasks(int[] selectedIndices) {
        List<Task> tasksToDelete = new ArrayList<>();
        for (int index : selectedIndices) {
            if (index >= 0 && index < tasks.size()) {
                Task taskToDelete = tasks.get(index);
                tasksToDelete.add(taskToDelete);
            }
        }
        tasks.removeAll(tasksToDelete);
        JOptionPane.showMessageDialog(null, "Tarefas excluídas permanentemente.", "Ação concluída",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showTrashBin() {
        // Exibe as tarefas na lixeira
        StringBuilder trashTasks = new StringBuilder("Tarefas na lixeira:\n");
        for (Task task : trashBin) {
            trashTasks.append(task.getDescription()).append("\n");
        }
        JOptionPane.showMessageDialog(null, trashTasks.toString(), "Lixeira", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para exibir a janela
    public void run() {
        this.setVisible(true);
    }
}
