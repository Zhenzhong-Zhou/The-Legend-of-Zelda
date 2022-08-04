package main;

import input.KeyInputs;
import input.MouseInputs;

import javax.swing.*;
import java.awt.*;

import static utility.Constant.SceneConstant.SCENE_HEIGHT;
import static utility.Constant.SceneConstant.SCENE_WIDTH;

public class Scene extends JPanel {
    private MouseInputs mouseInputs;
    private  Game game;

    public Scene(Game game) {
        this.game = game;
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
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        game.draw(graphics2D);
        graphics.dispose();
    }

    public Game getGame() {
        return game;
    }
}
