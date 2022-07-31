package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable {
    private Window window;
    private Screen screen;
    private Thread thread;
    private Player player;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Game() {
        initClasses();

        screen = new Screen(this);
        window = new Window(screen);

        start();
    }

    private void initClasses() {
        player = new Player(100, 100, 4);
    }

    private void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        player.update();
    }

    public void draw(Graphics2D graphics2D) {
        player.draw(graphics2D);
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
                screen.repaint();
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

    public Player getPlayer() {
        return player;
    }
}
