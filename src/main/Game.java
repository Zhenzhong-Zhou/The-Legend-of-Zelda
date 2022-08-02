package main;

import state.Menu;
import state.Play;

import java.awt.*;

import static state.GameState.gameState;
import static utility.Constant.GameConstant.FPS_SET;
import static utility.Constant.GameConstant.UPS_SET;

public class Game implements Runnable{
    private Window window;
    private Scene scene;
    private Thread thread;
    private Menu menu;
    private Play play;

    public Game() {
        initClasses();

        scene = new Scene(this);
        window = new Window(scene);
        scene.setFocusable(true);
        scene.requestFocus();

        start();
    }

    private void initClasses() {
        menu = new Menu(this);
        play = new Play(this);
    }


    public void update() {
        switch(gameState) {
            case MENU -> menu.update();
            case PLAY -> play.update();
            case EDITOR -> System.out.println("Editor");
            case OPTIONS -> System.out.println("Options");
            case QUIT -> System.exit(0);
            default -> {}
        }
    }

    public void draw(Graphics2D graphics2D) {
        switch(gameState) {
            case MENU -> menu.draw(graphics2D);
            case PLAY -> play.draw(graphics2D);
            case EDITOR -> System.out.println("Editor");
            case OPTIONS -> System.out.println("Options");
            case QUIT -> System.exit(0);
            default -> {}
        }
    }

    private void start() {
        thread = new Thread(this);
        thread.start();
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
                scene.repaint();
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

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }
}
