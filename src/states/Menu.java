package states;

import gui.Button;
import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;
import static utilities.Constant.GUI.Buttons.*;

public class Menu extends State implements StateMethods {
    private final Button[] buttons = new Button[5];

    public Menu(Scene scene) {
        super(scene);
        initButtons();
    }

    private void initButtons() {
        buttons[0] =  new Button(BUTTON_X, BUTTON_Y-Y_OFFSET*4, BUTTON_WIDTH, BUTTON_HEIGHT, "Start New Game", PLAY);
        buttons[1] =  new Button(BUTTON_X, BUTTON_Y-Y_OFFSET*3, BUTTON_WIDTH, BUTTON_HEIGHT, "Load Game", LOAD);
        buttons[2] =  new Button(BUTTON_X, BUTTON_Y-Y_OFFSET*2, BUTTON_WIDTH, BUTTON_HEIGHT, "Editor", EDITOR);
        buttons[3] =  new Button(BUTTON_X, BUTTON_Y -Y_OFFSET, BUTTON_WIDTH, BUTTON_HEIGHT, "Options", OPTIONS);
        buttons[4] =  new Button(BUTTON_X, BUTTON_Y , BUTTON_WIDTH, BUTTON_HEIGHT, "Quit", QUIT);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        for(Button button :  buttons) {
            button.draw(graphics2D);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Button button :  buttons) {
            if(isBound(e, button)) {
                button.applyGameState();
            }
        }
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
