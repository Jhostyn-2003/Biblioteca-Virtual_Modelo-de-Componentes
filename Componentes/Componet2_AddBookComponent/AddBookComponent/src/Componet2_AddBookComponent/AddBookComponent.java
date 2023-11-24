package Componet2_AddBookComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookComponent extends JFrame {
    private JTextField titleField;
    private JTextField authorField;
    private BookAddListener bookAddListener;

    public AddBookComponent() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Agregar Libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Título:");
        titleField = new JTextField();

        JLabel authorLabel = new JLabel("Autor:");
        authorField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void setBookAddListener(BookAddListener listener) {
        this.bookAddListener = listener;
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();

        if (bookAddListener != null) {
            bookAddListener.onBookAdded(title, author);
            // Mostrar el cuadro de diálogo cuando se agrega el libro
            JOptionPane.showMessageDialog(this, "Libro agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public interface BookAddListener {
        void onBookAdded(String title, String author);
    }
}
