package main;

import objects.Object;
import objects.ObjectManager;

import java.awt.*;

public class Game implements Runnable {
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;
    private final Window window;
    private final Screen screen;
    private Thread thread;
//    private ObjectManager objectManager;
//    public Object[] objects;

    public Game() {
        initClasses();

        screen = new Screen(this);
        window = new Window(screen);
        screen.setupGame();

        start();
    }

    private void initClasses() {
//        objectManager = new ObjectManager(screen);
//        objects = new Object[10];
    }
//
//    private void setupGame() {
//        objectManager.setObjects();
//    }

    private void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        screen.getPlayer().update();
    }

    public void draw(Graphics2D graphics2D) {
//        screen.getPlayer().draw(graphics2D);
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
//
//    public ObjectManager getObjectManager() {
//        return objectManager;
//    }
}
