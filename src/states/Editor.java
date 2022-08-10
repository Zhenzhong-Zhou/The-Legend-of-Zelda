package states;

import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;

public class Editor extends State implements StateMethods {
    public Editor(Scene scene) {
        super(scene);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawString("EDITOR", 50, 50);
        graphics2D.fillRect(150, 150, 150, 150);
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
        } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameState = PLAY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
