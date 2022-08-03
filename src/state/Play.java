package state;

import main.Game;
import managers.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static state.GameState.MENU;

public class Play extends State implements StateMethods {
    private LevelManager levelManager;

    public Play(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        levelManager = new LevelManager(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        levelManager.draw(graphics2D);
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
            case KeyEvent.VK_W -> System.out.println("UP");
            case KeyEvent.VK_A -> System.out.println("LEFT");
            case KeyEvent.VK_S -> System.out.println("DOWN");
            case KeyEvent.VK_D -> System.out.println("RIGHT");
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            GameState.gameState = MENU;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
