package gui;

import java.awt.*;

import static utilities.Constant.SceneConstant.SCENE_HEIGHT;

public class PauseOverlay {
    private GUI gui;

    public PauseOverlay(GUI gui) {
        this.gui = gui;
    }

    public void update() {

    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(gui.getMaruMonica());
        graphics2D.setColor(Color.WHITE);
        drawOverlay(graphics2D);
    }

    private void drawOverlay(Graphics2D graphics2D) {
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = gui.getHorizonCenteredText(graphics2D, text);
        int y = SCENE_HEIGHT / 2;
        graphics2D.drawString(text, x, y);
    }
}
