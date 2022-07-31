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
        double drawInterval = 1000000000.0/FPS_SET;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(thread != null) {
            long currentTime = System.nanoTime();
            // UPDATE: update information such as character positions
            update();
            // DRAW: draw the screen with the updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000.0;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
