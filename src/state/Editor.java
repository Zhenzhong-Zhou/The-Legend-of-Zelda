package state;

import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static state.GameState.PLAY;
import static state.GameState.gameState;

public class Editor extends State implements StateMethods{
    public Editor(Game game) {
        super(game);

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
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
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameState = PLAY;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
