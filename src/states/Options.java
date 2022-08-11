package states;

import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.MENU;
import static states.GameState.gameState;

public class Options extends State implements StateMethods {
    public Options(Scene scene) {
        super(scene);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.PINK);
        graphics2D.drawString("OPTIONS", 50, 50);
        graphics2D.fillRect(45, 50, 200, 100);
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
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameState = MENU;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
