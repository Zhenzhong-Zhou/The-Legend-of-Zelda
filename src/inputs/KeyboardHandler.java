package inputs;

import main.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
//    private final Screen screen;
    private boolean up, left, down, right;

//    public KeyboardHandler(Screen screen) {
//        this.screen = screen;
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_D -> right = true;
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

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
