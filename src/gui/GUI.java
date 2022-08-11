package gui;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constant.SceneConstant.SCENE_HEIGHT;
import static utilities.Constant.SceneConstant.TILE_SIZE;
import static utilities.LoadSave.*;

public class GUI {
    private final Play play;
    private Font maruMonica, purisaB;
    private BufferedImage key;
    private boolean notify;
    private String message = "";
    private int messageCounter = 0;

    public GUI(Play play) {
        this.play = play;

        initFont();
        loadImage();
    }

    private void initFont() {
        maruMonica = GetFont(MARU_MONICA).deriveFont(Font.PLAIN, 40);
        purisaB = GetFont(PURISA_BOLD);
    }

    private void loadImage() {
        key = GetSpriteAtlas(KEY_IMAGE);
    }

    public void displayMessage(String text) {
        message = text;
        notify = true;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(maruMonica);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawImage(key, TILE_SIZE / 2, TILE_SIZE / 2, TILE_SIZE, TILE_SIZE, null);
        graphics2D.drawString("x " + play.getPlayer().getHasKey(), 74, 65);

        // MESSAGE
        if(notify) {
            graphics2D.setFont(graphics2D.getFont().deriveFont(30f));
            graphics2D.drawString(message, TILE_SIZE / 2, SCENE_HEIGHT / 2);

            messageCounter++;

            if(messageCounter > 120) {
                messageCounter = 0;
                notify = false;
            }
        }
    }
}
