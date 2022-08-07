package states;

import entities.Player;
import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.MENU;
import static states.GameState.gameState;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class Play extends State implements StateMethods {
    private Player player;

    public Play(Scene scene) {
        super(scene);
        initClasses();
    }

    private void initClasses() {
        player = new Player(200, 200, 1, TILE_SIZE, TILE_SIZE, this);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
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

//    public Player getPlayer() {
//        return player;
//    }
}
