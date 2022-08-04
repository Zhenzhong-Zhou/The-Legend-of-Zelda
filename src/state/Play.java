package state;

import collision.CollisionDetection;
import entity.Player;
import main.Game;
import manager.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static state.GameState.MENU;
import static state.GameState.gameState;
import static utility.Constant.SceneConstant.SCALE;
import static utility.Constant.SceneConstant.TILE_SIZE;

public class Play extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private CollisionDetection collisionDetection;

    public Play(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        collisionDetection = new CollisionDetection(this);
        levelManager = new LevelManager(game);
        player = new Player(200, 200, 0.9f * SCALE, TILE_SIZE, TILE_SIZE, this);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D);
        player.draw(graphics2D);
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
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            gameState = MENU;
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

    public CollisionDetection getCollisionDetection() {
        return collisionDetection;
    }
}
