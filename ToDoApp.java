import javax.swing.*;
import java.awt.*;
import java.awt.event.DefaultListSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoApp() {
        // Main frame
        JFrame frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Panel for input and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text field for new task
        taskField = new JTextField();
        panel.add(taskField, BorderLayout.CENTER);

        // Add button
        JButton addButton = new JButton("Add");
        panel.add(addButton, BorderLayout.EAST);

        // List model and JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Delete button
        JButton deleteButton = new JButton("Delete Selected");

        // Add listeners
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        // Layout
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Show frame
        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskField.setText("");
        }
    }

    private void deleteTask() {
        int selected = taskList.getSelectedIndex();
        if (selected != -1) {
            taskListModel.remove(selected);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}