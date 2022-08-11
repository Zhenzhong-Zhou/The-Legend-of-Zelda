package states;

import entities.Player;
import gui.GUI;
import levels.LevelManager;
import main.Scene;
import objects.ObjectManager;
import utilities.CollisionDetection;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.MENU;
import static states.GameState.gameState;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class Play extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private ObjectManager objectManager;
    private CollisionDetection collisionDetection;
    private GUI gui;
    private boolean checkDrawDuration;

    public Play(Scene scene) {
        super(scene);
        initClasses();
    }

    private void initClasses() {
        gui = new GUI(this);
        collisionDetection = new CollisionDetection(this);
        levelManager = new LevelManager(scene);
        objectManager = new ObjectManager(this);
        player = new Player(200, 200, 1, TILE_SIZE, TILE_SIZE, this);
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
        gui.draw(graphics2D);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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
        }

        // DEBUG
        if(e.getKeyCode() == KeyEvent.VK_H) {
            checkDrawDuration = ! checkDrawDuration;
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

    public boolean isCheckDrawDuration() {
        return checkDrawDuration;
    }

    public CollisionDetection getCollisionDetection() {
        return collisionDetection;
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

    public GUI getGui() {
        return gui;
    }
}
