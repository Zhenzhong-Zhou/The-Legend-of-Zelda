package states;

import gui.Button;
import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static states.GameState.*;
import static utilities.Constant.GUI.Buttons.*;

public class Menu extends State implements StateMethods {
    private Button start, load, editor, options, quit;

    public Menu(Scene scene) {
        super(scene);
        initButtons();
    }

    private void initButtons() {
        start = new Button(BUTTON_X, 440, BUTTON_WIDTH, BUTTON_HEIGHT, "Start New Game", PLAY);
        load = new Button(BUTTON_X, 520, BUTTON_WIDTH, BUTTON_HEIGHT, "Load Game", PLAY);
        editor = new Button(BUTTON_X, 600, BUTTON_WIDTH, BUTTON_HEIGHT, "Editor", PLAY);
        options = new Button(BUTTON_X, 680, BUTTON_WIDTH, BUTTON_HEIGHT, "Options", PLAY);
        quit = new Button(BUTTON_X, 750 , BUTTON_WIDTH, BUTTON_HEIGHT, "Quit", PLAY);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        drawButtons(graphics2D);
    }

    private void drawButtons(Graphics2D graphics2D) {
        start.draw(graphics2D);
        load.draw(graphics2D);
        editor.draw(graphics2D);
        options.draw(graphics2D);
        quit.draw(graphics2D);
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
