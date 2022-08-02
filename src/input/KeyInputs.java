package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W -> System.out.println("UP");
            case KeyEvent.VK_A -> System.out.println("LEFT");
            case KeyEvent.VK_S -> System.out.println("DOWN");
            case KeyEvent.VK_D -> System.out.println("RIGHT");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
