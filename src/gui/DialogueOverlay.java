package gui;

import java.awt.*;

import static utilities.Constant.SceneConstant.SCENE_WIDTH;
import static utilities.Constant.SceneConstant.TILE_SIZE;

public class DialogueOverlay {
    private final GUI gui;

    public DialogueOverlay(GUI gui) {
        this.gui = gui;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(gui.getMaruMonica());
        graphics2D.setColor(Color.WHITE);
        drawOverlay(graphics2D);
    }

    private void drawOverlay(Graphics2D graphics2D) {
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 32F));
        // WINDOW
        int x = TILE_SIZE * 2;
        int y = TILE_SIZE / 2;
        int width = SCENE_WIDTH - (TILE_SIZE * 4);
        int height = TILE_SIZE * 5;
        gui.drawSubWindow(graphics2D, x, y, width, height);

        x += TILE_SIZE;
        y += TILE_SIZE;

        for(String line : gui.getCurrentDialogue().split("\n")) {
            gui.drawDialogue(graphics2D, line, x, y);
            y += 40;
        }
    }
}
