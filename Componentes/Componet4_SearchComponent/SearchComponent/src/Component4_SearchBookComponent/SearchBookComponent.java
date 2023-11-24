package Component4_SearchBookComponent;

import Componet3_BookTableComponent.BookTableComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchBookComponent extends JFrame {
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;

    private ArrayList<String> bookTitles = new ArrayList<>();
    private ArrayList<String> bookAuthors = new ArrayList<>();
    private BookTableComponent bookTableComponent;

    public SearchBookComponent(ArrayList<String> titles, ArrayList<String> authors, BookTableComponent bookTableComponent) {
        this.bookTitles = titles;
        this.bookAuthors = authors;
        this.bookTableComponent = bookTableComponent; // Guardar una referencia al componente de la tabla
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Buscar Libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        searchLabel = new JLabel("Buscar Título:");
        searchField = new JTextField();

        searchButton = new JButton("Buscar");
        searchButton.addActionListener(e -> searchBook());

        panel.add(searchLabel);
        panel.add(searchField);
        panel.add(searchButton);

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private void searchBook() {
        String searchText = searchField.getText();
        boolean found = false;

        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookTitles.get(i).equalsIgnoreCase(searchText)) {
                found = true;
                JOptionPane.showMessageDialog(this, "Libro encontrado en el sistema", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                showBookDetails(i);
                // Agregar el libro encontrado a la tabla
                bookTableComponent.addBookToTable(bookTitles.get(i), bookAuthors.get(i));
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No existe un libro con el nombre proporcionado", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void showBookDetails(int index) {
        String title = bookTitles.get(index);
        String author = bookAuthors.get(index);

        JFrame detailsFrame = new JFrame("Detalles del Libro");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailsFrame.setSize(300, 150);
        detailsFrame.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("Título: " + title);
        JLabel authorLabel = new JLabel("Autor: " + author);
        JLabel countLabel = new JLabel("Libros encontrados: " + bookTitles.size());

        detailsFrame.add(titleLabel);
        detailsFrame.add(authorLabel);
        detailsFrame.add(countLabel);

        detailsFrame.setLocationRelativeTo(null);
        detailsFrame.setVisible(true);
    }
}
