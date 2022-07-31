package inputs;

import main.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    private final Screen screen;
    private boolean up, left, down, right;

    public KeyboardHandler(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> screen.changeYDelta(-5);
            case KeyEvent.VK_A -> screen.changeXDelta(-5);
            case KeyEvent.VK_S -> screen.changeYDelta(5);
            case KeyEvent.VK_D -> screen.changeXDelta(5);
//            case KeyEvent.VK_SPACE -> player.setJump(true);
//            case KeyEvent.VK_ESCAPE -> paused = ! paused;
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_S -> down = false;
            case KeyEvent.VK_D -> right = false;
//            case KeyEvent.VK_SPACE -> player.setJump(true);
//            case KeyEvent.VK_ESCAPE -> paused = ! paused;
            default -> {
            }
        }
    }
}
