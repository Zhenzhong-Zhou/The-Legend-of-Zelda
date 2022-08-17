package states;

import gui.Button;
import gui.GUI;
import main.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static states.GameState.*;
import static utilities.Constant.GUI.Buttons.*;
import static utilities.Constant.SceneConstant.*;
import static utilities.LoadSave.DOWN_1_IMAGE;
import static utilities.LoadSave.GetSpriteAtlas;

public class Menu extends State implements StateMethods {
    private GUI gui;
    private final Button[] buttons = new Button[4];
    private int commandNum = 0;

    public Menu(Scene scene) {
        super(scene);
        gui = new GUI(scene);
        initButtons();
    }

    private void initButtons() {
        buttons[0] = new Button(BUTTON_X, BUTTON_Y - Y_OFFSET * 4, BUTTON_WIDTH, BUTTON_HEIGHT, "Play New Game", PLAY);
        buttons[1] = new Button(BUTTON_X, BUTTON_Y - Y_OFFSET * 3, BUTTON_WIDTH, BUTTON_HEIGHT, "Load Game", LOAD);
        buttons[2] = new Button(BUTTON_X, BUTTON_Y - Y_OFFSET * 2, BUTTON_WIDTH, BUTTON_HEIGHT, "Options", OPTIONS);
        buttons[3] = new Button(BUTTON_X, BUTTON_Y- Y_OFFSET, BUTTON_WIDTH, BUTTON_HEIGHT, "Quit", QUIT);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D graphics2D) {
        // TITLE
        drawTitle(graphics2D);

        // CHARACTER
        drawCharacter(graphics2D);

        // BUTTONS
//        for(Button button : buttons) {
//            button.draw(graphics2D);
//        }

        for(int i=0; i< buttons.length;i++) {
            if(commandNum == i) {
                graphics2D.drawString(">", BUTTON_X - TILE_SIZE, BUTTON_Y - Y_OFFSET * (3-i));
                buttons[i].draw(graphics2D);
            }
        }
    }

    public void drawTitle(Graphics2D graphics2D) {
        // TITLE
        graphics2D.setFont(scene.getGui().getMaruMonica().deriveFont(Font.BOLD, 96F));
        String title = "The Legend of Zelda";
        int x = gui.getHorizonCenteredText(graphics2D, title);
        int y = TILE_SIZE*4;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(title, x+5, y+5);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(title, x,y);
    }

    public void drawCharacter(Graphics2D graphics2D) {
        int x = SCENE_WIDTH/2-(TILE_SIZE*2)/2;
        int y = (int) (TILE_SIZE*3.5f);
        y+= TILE_SIZE*3;
        BufferedImage character = GetSpriteAtlas(DOWN_1_IMAGE);
        graphics2D.drawImage(character, x ,y, TILE_SIZE*2,TILE_SIZE*2, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Button button : buttons) {
            if(isBound(e, button)) {
                button.applyGameState();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(Button button : buttons) {
            if(isBound(e, button)) {
                button.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(Button button : buttons) {
            if(isBound(e, button)) {
                button.restBooleans();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(Button button : buttons) {
            button.setMouseHover(false);
        }

        for(Button button : buttons) {
            if(isBound(e, button)) {
                button.setMouseHover(true);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                commandNum--;
                if(commandNum<0) {
                    commandNum = 3;
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                commandNum++;
                if(commandNum>3) {
                    commandNum = 0;
                }
            }
            case KeyEvent.VK_ENTER -> {
                if(commandNum == 0) {
                    setGameStates(PLAY);
                }
                if(commandNum == 3) {
                    System.exit(0);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
