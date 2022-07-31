package inputs;

import main.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    private final Screen screen;

    public KeyboardHandler(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> screen.getPlayer().setUp(true);
            case KeyEvent.VK_A -> screen.getPlayer().setLeft(true);
            case KeyEvent.VK_S -> screen.getPlayer().setDown(true);
            case KeyEvent.VK_D -> screen.getPlayer().setRight(true);
//            case KeyEvent.VK_SPACE -> player.setJump(true);
//            case KeyEvent.VK_ESCAPE -> paused = ! paused;
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> screen.getPlayer().setUp(false);
            case KeyEvent.VK_A -> screen.getPlayer().setLeft(false);
            case KeyEvent.VK_S -> screen.getPlayer().setDown(false);
            case KeyEvent.VK_D -> screen.getPlayer().setRight(false);
//            case KeyEvent.VK_SPACE -> player.setJump(true);
//            case KeyEvent.VK_ESCAPE -> paused = ! paused;
            default -> {
            }
        }
    }
}
