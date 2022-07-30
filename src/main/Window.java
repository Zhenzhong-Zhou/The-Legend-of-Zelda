package main;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(Screen screen) {
        setTitle("The Legend of Zelda");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(screen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
