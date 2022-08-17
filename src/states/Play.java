package states;

import entities.EntityManager;
import entities.NPC_OldMan;
import entities.Player;
import gui.GUI;
import levels.LevelManager;
import main.Scene;
import objects.ObjectManager;
import utilities.CollisionDetection;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static utilities.Constant.SceneConstant.*;

public class Play extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private ObjectManager objectManager;
    private EntityManager entityManager;
    private NPC_OldMan npc_oldMan;
    private CollisionDetection collisionDetection;
    private GUI gui;
    private boolean checkDrawDuration;
    private boolean paused;

    public Play(Scene scene) {
        super(scene);
        initClasses();
    }

    private void initClasses() {
        gui = new GUI(this);
        collisionDetection = new CollisionDetection(this);
        levelManager = new LevelManager(scene);
        objectManager = new ObjectManager(this);
        entityManager = new EntityManager(this);
        npc_oldMan = new NPC_OldMan(this);
        player = new Player( this);
    }

    @Override
    public void update() {
        if(paused) {
            gui.getPauseOverlay().update();
        } else {
            entityManager.update();
            player.update();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D, player);
        objectManager.draw(graphics2D, player);
        entityManager.draw(graphics2D, player);
        player.draw(graphics2D);
        if(paused) {
            graphics2D.setColor(new Color(0, 0, 0, 150));
            graphics2D.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
            gui.getPauseOverlay().draw(graphics2D);
        }
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
            case KeyEvent.VK_ESCAPE -> paused = ! paused;
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

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
