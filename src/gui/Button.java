package gui;

import states.GameState;

import java.awt.*;

public class Button {
    private int x, y, width, height;
    private String buttonName;
    private GameState gameState;
    private Rectangle bounds;
    private boolean mouseHover, mousePressed;
    private Font maruMonica, purisaB;

    public Button(int x, int y, int width, int height, String buttonName, GameState gameState) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonName = buttonName;
        this.gameState = gameState;
        initBounds();
//        initFont();
    }

    private void initBounds() {
        bounds = new Rectangle(x,y, width,height);
    }

//    private void initFont() {
//
//        maruMonica = Font.createFont(Font.TRUETYPE_FONT, GetSpriteAtlas(MARU_MONICA));
//    }

    public void draw(Graphics2D graphics2D) {
        // BODY
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(x,y,width,height);

        // BORDER
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawRect(x,y,width,height);

        // TEXT
        drawText(graphics2D);
    }

    private void drawText(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
//        graphics2D.setFont();
        int widthName = graphics2D.getFontMetrics().stringWidth(buttonName);
        int heightName = graphics2D.getFontMetrics().getHeight();
        graphics2D.drawString(buttonName, x- widthName/2 + width/2, y+heightName/2+height/2);
    }

    public boolean isMouseHover() {
        return mouseHover;
    }

    public void setMouseHover(boolean mouseHover) {
        this.mouseHover = mouseHover;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void applyGameState() {
        GameState.gameState = gameState;
    }

    public void restBooleans() {
        mouseHover = false;
        mousePressed = false;
    }
}
