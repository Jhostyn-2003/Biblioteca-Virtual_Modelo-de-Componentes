package Componet3_BookTableComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BookTableComponent extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<String> bookTitles = new ArrayList<>();
    private ArrayList<String> bookAuthors = new ArrayList<>();

    public BookTableComponent() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Tabla de Libros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Título");
        tableModel.addColumn("Autor");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addBookToTable(String title, String author) {
        Object[] row = {title, author};
        tableModel.addRow(row);
        bookTitles.add(title);
        bookAuthors.add(author);
    }

    public ArrayList<String> getBookTitles() {
        return bookTitles;
    }

    public ArrayList<String> getBookAuthors() {
        return bookAuthors;
    }
}
