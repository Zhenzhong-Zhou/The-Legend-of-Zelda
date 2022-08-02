package main;

import javax.swing.*;
import java.awt.*;

import static utility.Constant.SceneConstant.SCENE_HEIGHT;
import static utility.Constant.SceneConstant.SCENE_WIDTH;

public class Scene extends JPanel {
    public Scene() {
        setSceneSize();
    }

    private void setSceneSize() {
        Dimension size = new Dimension(SCENE_WIDTH, SCENE_HEIGHT);
        setPreferredSize(size);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        System.out.println("Size: " + SCENE_WIDTH + ", " + SCENE_HEIGHT);
    }
}
