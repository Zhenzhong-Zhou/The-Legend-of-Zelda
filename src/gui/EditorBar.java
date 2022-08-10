package gui;

import states.Play;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilities.Constant.GUI.EditorBar.*;

public class EditorBar {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Play play;
    private final ArrayList<Button> tileButtons = new ArrayList<>();

    public EditorBar(int x, int y, int width, int height, Play play) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.play = play;
        initButtons();
    }

    private void initButtons() {
        ArrayList<Tile> tiles = play.getLevelManager().getTileManager().getTiles();
        for(int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            tileButtons.add(new Button(TILE_BUTTON_SIZE + X_OFFSET * i, BAR_Y + 10, TILE_BUTTON_SIZE, TILE_BUTTON_SIZE, tile.getTileName(), i));
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(220, 123, 15));
        graphics2D.fillRect(x, y, width, height);
        drawButtons(graphics2D);
    }

    private void drawButtons(Graphics2D graphics2D) {
        drawTileButtons(graphics2D);
    }

    private void drawTileButtons(Graphics2D graphics2D) {
        for(Button button : tileButtons) {
            Rectangle bounds = button.getBounds();
            graphics2D.drawImage(getButtonImage(button.getId()), bounds.x, bounds.y, bounds.width, bounds.height, null);
        }
    }

    private BufferedImage getButtonImage(int id) {
        return play.getLevelManager().getTileManager().getSprite(id);
    }
}
