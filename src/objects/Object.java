package objects;

import main.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilities.Constants.ScreenConstants.TILE_SIZE;

public class Object {
    protected BufferedImage image;
    protected String name;
    protected boolean collision = false;
    protected int worldX, worldY;

    public void draw(Graphics2D graphics2D, Screen screen) {
        int screenX = worldX - screen.getPlayer().getWorldX() + screen.getPlayer().getScreenX();
        int screenY = worldY - screen.getPlayer().getWorldY() + screen.getPlayer().getScreenY();

        int left = screen.getPlayer().getWorldX() - screen.getPlayer().getScreenX();
        int right = screen.getPlayer().getWorldX() + screen.getPlayer().getScreenX();
        int up = screen.getPlayer().getWorldY() - screen.getPlayer().getScreenY();
        int down = screen.getPlayer().getWorldY() + screen.getPlayer().getScreenY();

        if(worldX + TILE_SIZE > left && worldX - TILE_SIZE < right && worldY + TILE_SIZE > up && worldY - TILE_SIZE < down) {
            graphics2D.drawImage(image, screenX, screenY, TILE_SIZE, TILE_SIZE, null);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
