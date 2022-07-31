package main;

import inputs.KeyboardHandler;

import javax.swing.*;
import java.awt.*;

import static utilities.Constants.ScreenConstants.*;

public class Screen extends JPanel implements Runnable {
    private Game game;
    private Thread thread;
    private KeyboardHandler keyboardHandler = new KeyboardHandler();
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 4;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Screen(Game game) {
        this.game = game;
        setScreenSize();
        setDoubleBuffered(true);
        this.addKeyListener(keyboardHandler);
//        addKeyListener(new KeyboardHandler(this));
        setFocusable(true);
        requestFocus();
        start();
    }

    private void setScreenSize() {
        Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size: " + SCREEN_WIDTH + ", " + SCREEN_HEIGHT);
    }

    private void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        if(keyboardHandler.isUp()) {
            playerY -= playerSpeed;
        } else if(keyboardHandler.isLeft()) {
            playerX -= playerSpeed;
        } else if(keyboardHandler.isDown()) {
            playerY += playerSpeed;
        } else if(keyboardHandler.isRight()) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(playerX, playerY, TILE_SIZE,TILE_SIZE);
        graphics2D.dispose();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdates = 0;
        double deltaFrames = 0;

        while(thread != null) {
            long currentTime = System.nanoTime();
            deltaUpdates += (currentTime - lastTime) / timePerUpdate;
            deltaFrames += (currentTime - lastTime) / timePerFrame;

            lastTime = currentTime;
            // UPDATE: update information such as character positions
            if(deltaUpdates >= 1) {
                update();
                updates++;
                deltaUpdates--;
            }

            // DRAW: draw the screen with the updated information
            if(deltaFrames >= 1) {
                repaint();
                frames++;
                deltaFrames--;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
