package main;

import inputs.KeyboardHandler;
import inputs.MouseHandler;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

import static utilities.Constants.ScreenConstants.SCREEN_HEIGHT;
import static utilities.Constants.ScreenConstants.SCREEN_WIDTH;

public class Screen extends JPanel {
    private final Game game;
    private final MouseHandler mouseHandler;
    private TileManager tileManager;

    public Screen(Game game) {
        initClasses();

        mouseHandler = new MouseHandler(this);
        this.game = game;
        setScreenSize();
        setDoubleBuffered(true);
        addKeyListener(new KeyboardHandler(this));
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        setFocusable(true);
        requestFocus();
    }

    private void initClasses() {
        tileManager = new TileManager(this);
    }

    private void setScreenSize() {
        Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size: " + SCREEN_WIDTH + ", " + SCREEN_HEIGHT);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        tileManager.draw(graphics2D);
        game.draw(graphics2D);
        graphics2D.dispose();
    }

    public Game getGame() {
        return game;
    }
}
