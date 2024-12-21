package ui;

import server.HttpServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerControllerUI extends JFrame {
    private HttpServer server; // Référence au serveur
    private JButton startButton;
    private JButton stopButton;

    public ServerControllerUI(HttpServer server) {
        this.server = server;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Serveur HTTP Control");
        setSize(300, 150);
        setLocationRelativeTo(null); // Centrer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel pour les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Bouton Start
        startButton = new JButton("Démarrer Serveur");
        startButton.setEnabled(true);  // Actif au départ
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Désactiver Start et activer Stop
                startButton.setEnabled(false);
                stopButton.setEnabled(true);

                // Démarrer le serveur
                new Thread(() -> {
                    server.start();
                }).start();
            }
        });

        // Bouton Stop
        stopButton = new JButton("Arrêter Serveur");
        stopButton.setEnabled(false); // Inactif au départ
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Désactiver Stop et activer Start
                stopButton.setEnabled(false);
                startButton.setEnabled(true);

                // Arrêter le serveur
                server.stop();
            }
        });

        // Ajouter les boutons au panel
        panel.add(startButton);
        panel.add(stopButton);

        // Ajouter le panel à la fenêtre
        add(panel);

        // Afficher la fenêtre
        setVisible(true);
    }
}
