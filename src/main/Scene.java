package main;

import inputs.KeyInputs;
import inputs.MouseInputs;
import states.Editor;
import states.Menu;
import states.Options;
import states.Play;

import javax.swing.*;
import java.awt.*;

import java.text.DecimalFormat;

import static states.GameState.PLAY;
import static states.GameState.gameState;
import static utilities.Constant.GameConstant.FPS_SET;
import static utilities.Constant.GameConstant.UPS_SET;
import static utilities.Constant.SceneConstant.SCENE_HEIGHT;
import static utilities.Constant.SceneConstant.SCENE_WIDTH;

public class Scene extends JPanel implements Runnable {
    private final Game game;
    private Thread thread;
    private Menu menu;
    private Play play;
    private Editor editor;
    private Options options;
    private MouseInputs mouseInputs;

    public Scene(Game game) {
        this.game = game;
        setFocusable(true);
        requestFocus();
        setSceneSize();
        initClasses();
    }

    private void setSceneSize() {
        Dimension size = new Dimension(SCENE_WIDTH, SCENE_HEIGHT);
        setPreferredSize(size);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        System.out.println("Size: " + SCENE_WIDTH + ", " + SCENE_HEIGHT);
    }

    private void initClasses() {
        // Inputs Classes
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        // States Classes
        menu = new Menu(this);
        play = new Play(this);
        editor = new Editor(this);
        options = new Options(this);
    }

    public void update() {
        switch(gameState) {
            case MENU -> menu.update();
            case PLAY -> play.update();
            case EDITOR -> editor.update();
            case OPTIONS -> options.update();
            case QUIT -> System.exit(0);
            default -> {
            }
        }
    }

    public void draw(Graphics2D graphics2D) {
        switch(gameState) {
            case MENU -> menu.draw(graphics2D);
            case PLAY -> play.draw(graphics2D);
            case EDITOR -> editor.draw(graphics2D);
            case OPTIONS -> options.draw(graphics2D);
            case QUIT -> System.exit(0);
            default -> {
            }
        }
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        // DEBUG
        long drawStart = 0;
        if(play.isCheckDrawDuration()) drawStart = System.nanoTime();

        draw(graphics2D);

        // DEBUG
        if(play.isCheckDrawDuration()) {
            long drawEnd = System.nanoTime();
            long duration = drawEnd - drawStart;
            double second = (double) duration / 1000000000.0;
            DecimalFormat convert = new DecimalFormat();
            convert.setMaximumFractionDigits(8);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Duration: " + convert.format(second) + " seconds", 10, 400);
            System.out.println(convert.format(second) + " seconds");
        }

        graphics.dispose();
    }

    public void start() {
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

    public void windowFocusLost() {
        if(gameState == PLAY) {
           play.getPlayer().resetDirectionBoolean();
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public Play getPlay() {
        return play;
    }

    public Editor getEditor() {
        return editor;
    }

    public Options getOptions() {
        return options;
    }
}
