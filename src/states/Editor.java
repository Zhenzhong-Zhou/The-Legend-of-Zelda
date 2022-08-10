package states;

import entities.Player;
import gui.EditorBar;
import levels.LevelManager;
import main.Scene;
import objects.ObjectManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;
import static utilities.Constant.GUI.EditorBar.BAR_HEIGHT;
import static utilities.Constant.GUI.EditorBar.BAR_Y;
import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class Editor extends State implements StateMethods {
    private final EditorBar editorBar;
    private Player player;
    private LevelManager levelManager;
    private ObjectManager objectManager;

    public Editor(Scene scene) {
        super(scene);
        editorBar = new EditorBar(0, BAR_Y, SCENE_WIDTH, BAR_HEIGHT, scene.getPlay());
        initClasses();
    }

    private void initClasses() {
        levelManager = new LevelManager(scene);
        objectManager = new ObjectManager(scene.getPlay());
        player = new Player(200, 200, 1, TILE_SIZE, TILE_SIZE, scene.getPlay());
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D, player);
        objectManager.draw(graphics2D, player);
        player.draw(graphics2D);
        editorBar.draw(graphics2D);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getY() >= BAR_Y) {
            editorBar.mouseMoved(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(true);
            case KeyEvent.VK_A -> player.setLeft(true);
            case KeyEvent.VK_S -> player.setDown(true);
            case KeyEvent.VK_D -> player.setRight(true);
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState = MENU;
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameState = PLAY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(false);
            case KeyEvent.VK_A -> player.setLeft(false);
            case KeyEvent.VK_S -> player.setDown(false);
            case KeyEvent.VK_D -> player.setRight(false);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public EditorBar getEditorBar() {
        return editorBar;
    }
}
