package home;

import Componet2_AddBookComponent.AddBookComponent;
import Componet3_BookTableComponent.BookTableComponent;
import Component4_SearchBookComponent.SearchBookComponent;
import component_LoadingScreen.LoadingScreen;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static BookTableComponent bookTableComponent;
    private static boolean booksAdded = false;

    public static void main(String[] args) {
        LoadingScreen loadingScreen = new LoadingScreen();
        loadingScreen.setVisible(true);

        boolean loadingComplete = loadingScreen.simulateLoading();

        if (loadingComplete) {
            SwingUtilities.invokeLater(() -> {
                JFrame homeFrame = createHomeFrame();
                homeFrame.setVisible(true);
            });
        } else {
            System.out.println("Error: Loading failed.");
        }
    }

    private static JFrame createHomeFrame() {
        JFrame homeFrame = new JFrame("Home");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(400, 300);
        homeFrame.setLayout(new FlowLayout());

        JButton addButton = new JButton("Agregar Libro");
        JButton verifyButton = new JButton("Verificar Libros en el Sistema");
        JButton searchButton = new JButton("Buscar Libro");

        addButton.addActionListener(e -> openAddBookComponent());
        verifyButton.addActionListener(e -> openBookTableComponent());
        searchButton.addActionListener(e -> openSearchBookComponent());

        homeFrame.add(addButton);
        homeFrame.add(verifyButton);
        homeFrame.add(searchButton);

        homeFrame.setLocationRelativeTo(null);
        return homeFrame;
    }

    private static void openAddBookComponent() {
        AddBookComponent addBookComponent = new AddBookComponent();
        addBookComponent.setBookAddListener((title, author) -> {
            if (!booksAdded) {
                bookTableComponent = new BookTableComponent();
                bookTableComponent.setVisible(false);
                booksAdded = true;
            }
            bookTableComponent.addBookToTable(title, author);
        });
        addBookComponent.setVisible(true);
    }

    private static void openBookTableComponent() {
        if (booksAdded) {
            bookTableComponent.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Agregue libros primero", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void openSearchBookComponent() {
        if (booksAdded) {
            SearchBookComponent searchBookComponent = new SearchBookComponent(
                    bookTableComponent.getBookTitles(),
                    bookTableComponent.getBookAuthors(),
                    bookTableComponent
            );
            searchBookComponent.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Agregue libros primero", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
}