package main;

import javax.swing.*;
import java.awt.*;

import static utilities.Constants.ScreenConstants.SCREEN_HEIGHT;
import static utilities.Constants.ScreenConstants.SCREEN_WIDTH;

public class Screen extends JPanel {
    private Game game;

    public Screen(Game game) {
        this.game = game;
        setScreenSize();
        setDoubleBuffered(true);
    }

    private void setScreenSize() {
        Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size: " + SCREEN_WIDTH + ", " + SCREEN_HEIGHT);
    }
}
