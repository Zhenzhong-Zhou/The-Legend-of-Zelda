package gui;

import states.Play;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import static utilities.Constant.SceneConstant.*;
import static utilities.LoadSave.*;

public class GUI {
    private final Play play;
    private Font maruMonica, purisaB;
    private BufferedImage key;
    private boolean notify;
    private String message = "";
    private int messageCounter = 0;
    private boolean gameCompleted;
    private double timer;

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
        DecimalFormat convert = new DecimalFormat();
        convert.setMaximumFractionDigits(2);

        if(gameCompleted) {
            graphics2D.setFont(maruMonica);
            graphics2D.setColor(Color.WHITE);
            String text;
            int textLength;
            int x, y;

            text = "You found the treasure!";
            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
            x = SCENE_WIDTH / 2 - textLength / 2;
            y = SCENE_HEIGHT / 2 - TILE_SIZE*3;
            graphics2D.drawString(text,  x, y );

            text = "Your Time is: " + convert.format(timer) + "!";
            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
            x = SCENE_WIDTH / 2 - textLength / 2;
            y = SCENE_HEIGHT / 2 + TILE_SIZE*4;
            graphics2D.drawString(text,  x, y);

            graphics2D.setFont(purisaB);
            graphics2D.setColor(Color.YELLOW);
            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 80));

            text = "Congratulation!";
            textLength = (int) graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
            x = SCENE_WIDTH / 2 - textLength / 2;
            y = SCENE_HEIGHT / 2 + TILE_SIZE*2;
            graphics2D.drawString(text,  x, y );
        } else {
            graphics2D.setFont(maruMonica);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawImage(key, TILE_SIZE / 2, TILE_SIZE / 2, TILE_SIZE, TILE_SIZE, null);
            graphics2D.drawString("x " + play.getPlayer().getHasKey(), 74, 65);

            // TIMER
            timer +=  (double)1/60;
            graphics2D.drawString("Time: " + convert.format(timer), SCENE_WIDTH - 175, 65);

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

    public boolean isGameCompleted() {
        return gameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        this.gameCompleted = gameCompleted;
    }
}
