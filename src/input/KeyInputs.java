package input;

import main.Scene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static state.GameState.gameState;

public class KeyInputs implements KeyListener {
    private final Scene scene;

    public KeyInputs(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(gameState) {
            case MENU -> scene.getGame().getMenu().keyPressed(e);
            case PLAY -> scene.getGame().getPlay().keyPressed(e);
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(gameState) {
            case MENU -> scene.getGame().getMenu().keyPressed(e);
            case PLAY -> scene.getGame().getPlay().keyPressed(e);
            default -> {
            }
        }
    }
}
