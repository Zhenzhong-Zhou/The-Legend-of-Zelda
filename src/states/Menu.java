package states;

import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;

public class Menu extends State implements StateMethods {
    public Menu(Scene scene) {
        super(scene);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("MENU", 50, 50);
        graphics2D.fillRect(200, 200, 100, 50);
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
            case KeyEvent.VK_ENTER -> gameState = PLAY;
            case KeyEvent.VK_SPACE -> gameState = EDITOR;
            case KeyEvent.VK_SHIFT -> gameState = OPTIONS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
