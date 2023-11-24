package component_LoadingScreen;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JFrame {
    private JProgressBar progressBar;

    public LoadingScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Loading Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        add(progressBar);
        setLocationRelativeTo(null);
    }

    public boolean simulateLoading() {
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100); // Simula el tiempo de carga
                progressBar.setValue(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false; // En caso de error durante la carga
        }
        setVisible(false);
        return true; // Devuelve true una vez que la carga está completa
    }
}