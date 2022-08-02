package main;

import input.KeyInputs;

import javax.swing.*;
import java.awt.*;

import static utility.Constant.SceneConstant.SCENE_HEIGHT;
import static utility.Constant.SceneConstant.SCENE_WIDTH;

public class Scene extends JPanel {
    public Scene() {
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
        addKeyListener(new KeyInputs());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.dispose();
    }
}
