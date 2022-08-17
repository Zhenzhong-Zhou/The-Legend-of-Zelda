package gui;

import states.Play;

import java.awt.*;
import java.awt.event.MouseEvent;

import static states.GameState.*;
import static utilities.Constant.GUI.Buttons.*;
import static utilities.Constant.GUI.Buttons.BUTTON_HEIGHT;
import static utilities.Constant.SceneConstant.*;

public class PauseOverlay {
    private final GUI gui;
    private PauseButton menu, options, control, quit;

    public PauseOverlay(GUI gui) {
        this.gui = gui;

        initButtons();
    }

    private void initButtons() {
        int height = BUTTON_HEIGHT-10;
        menu = new PauseButton(BUTTON_X, BUTTON_Y - Y_OFFSET * 6, BUTTON_WIDTH, height, "Menu");
        options = new PauseButton(BUTTON_X, BUTTON_Y - Y_OFFSET * 5, BUTTON_WIDTH, height, "Options");
        control = new PauseButton(BUTTON_X, BUTTON_Y - Y_OFFSET * 4, BUTTON_WIDTH, height, "Control");
        quit = new PauseButton(BUTTON_X, BUTTON_Y - Y_OFFSET * 3, BUTTON_WIDTH, height, "Quit");
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(gui.getMaruMonica());
        graphics2D.setColor(Color.WHITE);
        drawOverlay(graphics2D);

        // BUTTONS
        menu.draw(graphics2D);
        options.draw(graphics2D);
        control.draw(graphics2D);
        quit.draw(graphics2D);
    }

    private void drawOverlay(Graphics2D graphics2D) {
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = gui.getHorizonCenteredText(graphics2D, text);
        int y = TILE_SIZE*6;
        gui.drawSubWindow(graphics2D, SCENE_WIDTH/2 - x/2 +85, y -100, 300, 500);
        graphics2D.drawString(text, x, y);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if(menu.isBound(e, menu)) {
            menu.setMousePressed(true);
            gameState = MENU;
            gui.resume();
        }
    }

    public void mouseReleased(MouseEvent e) {
        if(menu.isBound(e, menu)) {
            if(menu.isMousePressed()) {
                menu.restBooleans();
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        menu.setMouseHover(false);

        if(menu.isBound(e, menu)) {
            menu.setMouseHover(true);
        }
    }
}
