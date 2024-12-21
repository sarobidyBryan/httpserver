package main;

import server.*;
import ui.*;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        Configuration conf = new Configuration();
        
        int port = conf.getPort();
        String rootDirectory = conf.getRootDirectory();

        HttpServer server = new HttpServer(port, rootDirectory);

        SwingUtilities.invokeLater(() -> {
            ServerControllerUI ui = new ServerControllerUI(server);
            ui.setVisible(true);
        });
    }
}
