package main;

import server.*;
import ui.*;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();

        SwingUtilities.invokeLater(() -> {
            ServerControllerUI ui = new ServerControllerUI(server);
            ui.setVisible(true);
        });
    }
}
